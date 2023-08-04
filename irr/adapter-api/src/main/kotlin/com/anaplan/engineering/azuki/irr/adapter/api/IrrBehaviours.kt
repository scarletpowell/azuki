package com.anaplan.engineering.azuki.irr.adapter.api

import com.anaplan.engineering.azuki.core.system.Behavior
import com.anaplan.engineering.azuki.core.system.ReifiedBehavior

object IrrBehaviours {
    const val CreateCashFlowSeries = 1
    const val AddToEnd = 2
    const val CreateIrr = 3
}

open class CreateCashFlowSeriesBehaviour : ReifiedBehavior {
    override val behavior = IrrBehaviours.CreateCashFlowSeries
}

open class AddToEndBehaviour : ReifiedBehavior {
    override val behavior = IrrBehaviours.AddToEnd
}

open class CreateIrrBehaviour : ReifiedBehavior {
    override val behavior = IrrBehaviours.CreateIrr
}
