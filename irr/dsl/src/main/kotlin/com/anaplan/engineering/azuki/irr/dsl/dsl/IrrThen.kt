package com.anaplan.engineering.azuki.irr.dsl.dsl

import com.anaplan.engineering.azuki.core.dsl.Then
import com.anaplan.engineering.azuki.core.system.Check
import com.anaplan.engineering.azuki.irr.adapter.api.IrrCheckFactory
import javax.swing.text.html.parser.Entity

class IrrThen(private val checkFactory: IrrCheckFactory): Then<IrrCheckFactory> {

    private val checkList = mutableListOf<Check>()

    override fun checks() = checkList

    fun hasIrrValue(cashFlowSeriesName: String, result: Double) {
        checkList.add(checkFactory.hasIrrValue(cashFlowSeriesName, result))
    }

    fun everythingIsOk() {
        checkList.add(checkFactory.systemValid())
    }
}
