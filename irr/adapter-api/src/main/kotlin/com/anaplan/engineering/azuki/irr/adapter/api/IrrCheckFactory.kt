package com.anaplan.engineering.azuki.irr.adapter.api

import com.anaplan.engineering.azuki.core.system.Check
import com.anaplan.engineering.azuki.core.system.CheckFactory
import com.anaplan.engineering.azuki.core.system.UnsupportedCheck

interface IrrCheckFactory: CheckFactory {
    fun hasIrrValue(cashFlowSeriesName: String, result: Double): Check = UnsupportedCheck
}
