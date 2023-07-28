package com.anaplan.engineering.azuki.irr.adapter.irr.execution


class ExecutionEnvironment {

    val cashflows = mutableMapOf<String, Double>()
    val cashFlowLists = mutableMapOf<String, List<Double>>()

    fun act(name: String, action: List<Double>.() -> Unit) =
        cashFlowLists[name]?.action() ?: throw ExecutionException("No such list $name")

    fun addIrr(name: String, value: Double) {

    }
}

class ExecutionException(msg: String): RuntimeException(msg)

