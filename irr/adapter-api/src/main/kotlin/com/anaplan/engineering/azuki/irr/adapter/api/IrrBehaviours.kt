package com.anaplan.engineering.azuki.irr.adapter.api

import com.anaplan.engineering.azuki.core.system.ReifiedBehavior

object IrrBehaviours {
    const val CreateCashFlowSeries = 1
}

open class CreateCashFlowSeriesBehaviour : ReifiedBehavior {
    override val behavior = IrrBehaviours.CreateCashFlowSeries
}
