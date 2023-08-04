package com.anaplan.engineering.azuki.irr.adapter.irr.action

import com.anaplan.engineering.azuki.core.system.LateDetectUnsupportedActionException
import com.anaplan.engineering.azuki.irr.adapter.declaration.action.CreateCashFlowSeriesDeclarableAction
import com.anaplan.engineering.azuki.irr.adapter.declaration.action.CreateIrrDeclarableAction
import com.anaplan.engineering.azuki.irr.adapter.irr.execution.ExecutionEnvironment


class CreateIrrAction(irrName: String, cashFlowSeriesName: String) :
    CreateIrrDeclarableAction(irrName, cashFlowSeriesName), IRRAction {

    override fun act(env: ExecutionEnvironment) {
        throw LateDetectUnsupportedActionException()
    }
}
