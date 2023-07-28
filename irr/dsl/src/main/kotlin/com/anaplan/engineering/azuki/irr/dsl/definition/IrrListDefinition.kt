package com.anaplan.engineering.azuki.irr.dsl.definition

interface cashFlowSeriesDefinition {

    fun cashFlowSeries(cashFlowSeriesName: String, vararg cashFlows: Double)
}
