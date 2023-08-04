package com.anaplan.engineering.azuki.irr.analysis

import com.anaplan.engineering.azuki.core.runner.AnalysisScenario
import com.anaplan.engineering.azuki.irr.dsl.dsl.IrrScenario
import com.anaplan.engineering.azuki.irr.cashFlowA
import com.anaplan.engineering.azuki.irr.irrA

class NewIrr: IrrScenario() {

    @AnalysisScenario
    fun newEmptyCashFlowSeriesIsOkay() {
        given {
            cashFlowSeries(cashFlowA)
        }
        then {
            everythingIsOk()
        }
    }

    @AnalysisScenario
    fun newCashFlowSeriesIsOkay() {
        given {
            cashFlowSeries(cashFlowA, 1.0, 2.0)
        }
        then {
            everythingIsOk()
        }
    }

    @AnalysisScenario
    fun newCashFlowSeries() {
        given {
            cashFlowSeries(cashFlowA, 1.0, 2.0)
            thereIsAnIrr(irrA, cashFlowA)
        }
        then {
            everythingIsOk()
        }
    }
}
