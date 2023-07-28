package com.anaplan.engineering.azuki.irr.analysis

import com.anaplan.engineering.azuki.core.runner.AnalysisScenario
import com.anaplan.engineering.azuki.irr.dsl.dsl.IrrScenario
import com.anaplan.engineering.azuki.irr.cashFlowA

class NewIrr: IrrScenario() {

    @AnalysisScenario
    fun newIrrIsOkay() {
        given {
            cashFlowSeries(cashFlowA)
        }
        then {
            everythingIsOk()
        }
    }

    @AnalysisScenario
    fun newIrr() {
        given {
            cashFlowSeries(cashFlowA, 1.0)
        }
        then {
            hasIrrValue(cashFlowA, 0.0)
        }
    }
}
