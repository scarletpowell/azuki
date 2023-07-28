package com.anaplan.engineering.azuki.irr.adapter.irr

import com.anaplan.engineering.azuki.core.system.*
import com.anaplan.engineering.azuki.declaration.Declaration
import com.anaplan.engineering.azuki.declaration.DeclarationBuilderFactory
import com.anaplan.engineering.azuki.irr.adapter.api.IrrActionFactory
import com.anaplan.engineering.azuki.irr.adapter.api.IrrCheckFactory
import com.anaplan.engineering.azuki.irr.adapter.declaration.DeclarableAction
import com.anaplan.engineering.azuki.irr.adapter.declaration.DeclarationBuilder
import com.anaplan.engineering.azuki.irr.adapter.declaration.toDeclarableAction
import com.anaplan.engineering.azuki.irr.adapter.irr.action.IRRAction
import com.anaplan.engineering.azuki.irr.adapter.irr.action.IRRActionFactory
import com.anaplan.engineering.azuki.irr.adapter.irr.action.toIRRAction
import com.anaplan.engineering.azuki.irr.adapter.irr.check.IRRCheck
import com.anaplan.engineering.azuki.irr.adapter.irr.check.IRRCheckFactory
import com.anaplan.engineering.azuki.irr.adapter.irr.check.toIRRCheck
import com.anaplan.engineering.azuki.irr.adapter.irr.declaration.IRRDeclarationBuilder
import com.anaplan.engineering.azuki.irr.adapter.irr.declaration.IRRDeclarationBuilderFactory
import com.anaplan.engineering.azuki.irr.adapter.irr.execution.ExecutionEnvironment
import org.slf4j.LoggerFactory

class IRRSystemFactory : SystemFactory<
    IrrActionFactory,
    IrrCheckFactory,
    NoQueryFactory,
    NoActionGeneratorFactory,
    NoSystemDefaults
    > {
    override fun create(systemDefinition: SystemDefinition): System<IrrActionFactory, IrrCheckFactory> {
        return IRRSystem(
            systemDefinition.declarations.map(toDeclarableAction),
            systemDefinition.actions.map(toIRRAction),
            systemDefinition.checks.map(toIRRCheck),
        )
    }

    override val actionFactory = IRRActionFactory()
    override val checkFactory = IRRCheckFactory()
    override val queryFactory = NoQueryFactory
    override val actionGeneratorFactory = NoActionGeneratorFactory

}

data class IRRSystem(
    val declarableActions: List<DeclarableAction>,
    val buildActions: List<IRRAction>,
    val checks: List<IRRCheck>
) : System<IRRFactory, IrrCheckFactory> {

    override val supportedActions = if (checks.isNotEmpty()) {
        setOf(System.SystemAction.Verify)
    } else {
        setOf()
    }

    override fun verify(): VerificationResult {
        val env = ExecutionEnvironment()
        return try {
            build(env)
            if (runAllChecks(env)) {
                VerificationResult.Verified()
            } else {
                VerificationResult.Unverified()
            }
        } catch (e: LateDetectUnsupportedActionException) {
            Log.info("Unsupported action", e)
            throw e
        }
    }

    private fun runAllChecks(env: ExecutionEnvironment) =
        checks.fold(true) { l, r ->
            l && try {
                r.check(env)
            } catch (e: LateDetectUnsupportedCheckException) {
                handleLateDetectedUnsupportedCheck(e)
            }
        }

    private fun handleLateDetectedUnsupportedCheck(e: LateDetectUnsupportedCheckException): Boolean {
        Log.info("Skipping late detected unsupported check", e)
        return true
    }

    private fun build(env: ExecutionEnvironment) {
        val declarationBuilders = DeclarationBuilder(declarableActions).build().map { declarationBuilder(it) }
        declarationBuilders.forEach { it.build(env) }
        buildActions.forEach { it.act(env) }
    }

    private fun <D : Declaration> declarationBuilder(declaration: D) =
        declarationBuilderFactory.createBuilder<D, IRRDeclarationBuilder<D>>(declaration)


    override fun generateReport(name: String) = throw UnsupportedOperationException()

    override fun query() = throw UnsupportedOperationException()

    override fun generateActions() = throw UnsupportedOperationException()

    companion object {
        private val declarationBuilderFactory = DeclarationBuilderFactory(IRRDeclarationBuilderFactory::class.java)

        private val Log = LoggerFactory.getLogger(IRRSystemFactory::class.java)
    }
}


