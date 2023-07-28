package com.anaplan.engineering.azuki.irr.adapter.irr.action

import com.anaplan.engineering.azuki.irr.adapter.irr.execution.ExecutionEnvironment

class AddToEndAction(cashFlowSeriesName: String, cashflow: Double) :
    AddToEndDeclarableAction(cashFlowSeriesName, listOf(cashflow)), IRRAction{

    override fun act(env: ExecutionEnvironment) {
        TODO("Not yet implemented")
    }
}
