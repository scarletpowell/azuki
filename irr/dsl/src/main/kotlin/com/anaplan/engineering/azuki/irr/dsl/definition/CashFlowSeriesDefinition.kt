package com.anaplan.engineering.azuki.irr.dsl.definition

interface CashFlowSeriesDefinition {

    fun cashFlowSeries(cashFlowSeriesName: String, vararg cashFlows: Double)
}
