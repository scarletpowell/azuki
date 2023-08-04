package com.anaplan.engineering.azuki.irr.dsl.dsl

import com.anaplan.engineering.azuki.core.dsl.Then
import com.anaplan.engineering.azuki.core.system.Check
import com.anaplan.engineering.azuki.irr.adapter.api.IrrCheckFactory

class IrrThen(private val checkFactory: IrrCheckFactory): Then<IrrCheckFactory> {

    private val checkList = mutableListOf<Check>()

    override fun checks() = checkList

    fun irrHasValue(irrName: String, result: Double) {
        checkList.add(checkFactory.irrHasValue(irrName, result))
    }

    fun everythingIsOk() {
        checkList.add(checkFactory.systemValid())
    }
}
