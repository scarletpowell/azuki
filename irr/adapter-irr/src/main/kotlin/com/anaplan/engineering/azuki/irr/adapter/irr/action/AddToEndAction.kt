package com.anaplan.engineering.azuki.irr.adapter.irr.action

import com.anaplan.engineering.azuki.core.system.Behavior
import com.anaplan.engineering.azuki.core.system.LateDetectUnsupportedActionException
import com.anaplan.engineering.azuki.irr.adapter.declaration.action.AddToEndDeclarableAction
import com.anaplan.engineering.azuki.irr.adapter.irr.execution.ExecutionEnvironment

class AddToEndAction(cashFlowSeriesName: String, cashFlow: Double) :
    AddToEndDeclarableAction(cashFlowSeriesName, cashFlow), IRRAction{
    override val behavior: Behavior = -1
    override fun act(env: ExecutionEnvironment) {
        throw LateDetectUnsupportedActionException()
    }
}


