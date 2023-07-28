package com.anaplan.engineering.azuki.irr.adapter.declaration.action

import com.anaplan.engineering.azuki.irr.adapter.declaration.DeclarationBuilder
import com.anaplan.engineering.azuki.irr.adapter.declaration.DeclarableAction
import com.anaplan.engineering.azuki.irr.adapter.api.CreateCashFlowSeriesBehaviour

abstract class CreateCashFlowSeriesDeclarableAction(
    protected val cashFlowSeriesName: String
): CreateCashFlowSeriesBehaviour(), DeclarableAction {

    override fun declare(builder: DeclarationBuilder) {
        builder.declareCashFlowSeries(cashFlowSeriesName)
    }
}
