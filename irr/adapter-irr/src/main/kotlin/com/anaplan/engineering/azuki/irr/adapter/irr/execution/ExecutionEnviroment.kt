package com.anaplan.engineering.azuki.irr.adapter.irr.execution


class ExecutionEnvironment {

    val cashFlowLists = mutableMapOf<String, List<Double>>()
    val irrValues = mutableMapOf<String, Double>()

    fun addCashFlowSeries(name: String, values: List<Double>) {
        if (cashFlowLists.containsKey(name)) throw  ExecutionException("Cash Flow Series $name already exists")
        cashFlowLists[name] = values
    }

    fun addIrr(irrName: String, value: Double) {
        if (irrValues.containsKey(irrName)) throw ExecutionException("Irr value $irrName already exists")
        irrValues[irrName] = value
    }
}

class ExecutionException(msg: String): RuntimeException(msg)

