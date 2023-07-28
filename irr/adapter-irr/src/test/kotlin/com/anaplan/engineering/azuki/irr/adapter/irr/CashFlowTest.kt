package com.anaplan.engineering.azuki.irr.adapter.irr

import com.anaplan.engineering.azuki.core.runner.AdapterTest
import com.anaplan.engineering.azuki.irr.dsl.dsl.IrrScenario

class CashFlowTest : IrrScenario() {

    private val cashFlowA = "cashFlowA"

    // TODO: why is this not being picked up by the test runner?
    @AdapterTest
    fun newCashFlowSeriesIsOkay() {
        given {
            cashFlowSeries(cashFlowA)
        }
        then {
            everythingIsOk()
        }
    }
}
