package com.anaplan.engineering.azuki.irr.adapter.irr.execution


class ExecutionEnvironment {

    val cashflows = mutableMapOf<String, Double>()
    val cashFlowLists = mutableMapOf<String, List<Double>>()

    fun act(name: String, action: List<Double>.() -> Unit) =
        cashFlowLists[name]?.action() ?: throw ExecutionException("No such list $name")

    fun addCashFlowSeries(name: String, values: List<Double>) {
        if (cashFlowLists.containsKey(name)) throw  ExecutionException("Cash Flow Series $name already exists")
        cashFlowLists[name] = values
    }
}

class ExecutionException(msg: String): RuntimeException(msg)

