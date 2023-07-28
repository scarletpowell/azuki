package com.anaplan.engineering.azuki.irr.adapter.irr.action

import com.anaplan.engineering.azuki.core.system.Behavior
import com.anaplan.engineering.azuki.irr.adapter.declaration.DeclarableAction
import com.anaplan.engineering.azuki.irr.adapter.declaration.DeclarationBuilder
import com.anaplan.engineering.azuki.irr.adapter.irr.execution.ExecutionEnvironment

class AddToEndAction(cashFlowSeriesName: String, cashFlow: Double) :
    AddToEndDeclarableAction(cashFlowSeriesName, listOf(cashFlow)), IRRAction{

    override fun act(env: ExecutionEnvironment) {
        TODO("Not yet implemented")
    }
}

// TODO: populate
abstract class AddToEndDeclarableAction(protected val cashFlowSeriesName: String, protected val cashFlows: List<Double>) : DeclarableAction {

    override val behavior: Behavior = -1
    override fun declare(builder: DeclarationBuilder) {
        TODO("Not yet implemented")
    }
}
