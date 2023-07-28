package com.anaplan.engineering.azuki.irr.adapter.irr.declaration

import com.anaplan.engineering.azuki.irr.adapter.declaration.declaration.CashFlowSeriesDeclaration
import com.anaplan.engineering.azuki.irr.adapter.declaration.declaration.IrrDeclaration
import com.anaplan.engineering.azuki.irr.adapter.irr.execution.ExecutionEnvironment


class CreateCashFlowSeriesDeclarationBuilderFactory : IrrPoiDeclarationBuilderFactory<CashFlowSeriesDeclaration> {

    override val declarationClass = CashFlowSeriesDeclaration::class.java

    override fun create(declaration: CashFlowSeriesDeclaration): IrrPoiDeclarationBuilder<CashFlowSeriesDeclaration> =
        CashFlowSeriesDeclarationBuilder(declaration)

    private class CashFlowSeriesDeclarationBuilder(declaration: CashFlowSeriesDeclaration) :
        IrrPoiDeclarationBuilder<CashFlowSeriesDeclaration>(declaration) {

        override fun build(env: ExecutionEnvironment) {
            env.addCashFlowSeries(declaration.name, declaration.cashFlows)
        }

    }
}
