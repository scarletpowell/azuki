package com.anaplan.engineering.azuki.irr.adapter.declaration.action

import com.anaplan.engineering.azuki.irr.adapter.declaration.DeclarationBuilder
import com.anaplan.engineering.azuki.irr.adapter.declaration.DeclarableAction
import com.anaplan.engineering.azuki.irr.adapter.api.CreateCashFlowSeriesBehaviour
import com.anaplan.engineering.azuki.irr.adapter.api.CreateIrrBehaviour

abstract class CreateIrrDeclarableAction(
    protected val irrName: String,
    protected val cashFlowSeriesName: String
): CreateIrrBehaviour(), DeclarableAction {

    override fun declare(builder: DeclarationBuilder) {
        builder.declareIrr(irrName, cashFlowSeriesName)
    }
}
