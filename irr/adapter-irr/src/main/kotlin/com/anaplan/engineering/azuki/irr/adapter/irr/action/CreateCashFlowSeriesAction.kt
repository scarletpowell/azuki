package com.anaplan.engineering.azuki.irr.adapter.irr.action

import com.anaplan.engineering.azuki.core.system.LateDetectUnsupportedActionException
import com.anaplan.engineering.azuki.irr.adapter.declaration.action.CreateCashFlowSeriesDeclarableAction
import com.anaplan.engineering.azuki.irr.adapter.irr.execution.ExecutionEnvironment


class CreateCashFlowSeriesAction(cashFlowSeriesName: String) :
    CreateCashFlowSeriesDeclarableAction(cashFlowSeriesName), IRRAction {

    override fun act(env: ExecutionEnvironment) {
        throw LateDetectUnsupportedActionException()
    }
}
