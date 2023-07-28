package com.anaplan.engineering.azuki.irr.dsl.dsl

import com.anaplan.engineering.azuki.core.dsl.When
import com.anaplan.engineering.azuki.core.system.Action
import com.anaplan.engineering.azuki.irr.adapter.api.IrrActionFactory

class IrrWhen(val actionFactory: IrrActionFactory): When<IrrActionFactory> {

    private val actionList = mutableListOf<Action>()

    override fun actions() = actionList

}
