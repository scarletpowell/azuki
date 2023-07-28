package com.anaplan.engineering.azuki.irr.dsl.dsl

import com.anaplan.engineering.azuki.core.dsl.RegardlessOf
import com.anaplan.engineering.azuki.core.system.Action
import com.anaplan.engineering.azuki.irr.adapter.api.IrrActionFactory

class IrrRegardlessOf(private val actionFactory: IrrActionFactory): RegardlessOf<IrrActionFactory> {

    private val actionList = mutableListOf<Action>()

    override fun actions(): List<Action> = actionList

}
