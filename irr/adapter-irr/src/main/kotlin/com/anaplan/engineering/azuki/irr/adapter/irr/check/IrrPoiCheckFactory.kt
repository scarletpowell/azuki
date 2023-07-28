package com.anaplan.engineering.azuki.irr.adapter.irr.check

import com.anaplan.engineering.azuki.core.system.Behavior
import com.anaplan.engineering.azuki.core.system.Check
import com.anaplan.engineering.azuki.irr.adapter.api.IrrCheckFactory
import com.anaplan.engineering.azuki.irr.adapter.irr.execution.ExecutionEnvironment

class IrrPoiCheckFactory: IrrCheckFactory {
    override fun systemValid() = IrrSystemValidCheck
}

object IrrSystemValidCheck : IrrCheck {
    override val behavior = -1
    override fun check(env: ExecutionEnvironment) = true
}

interface IrrCheck : Check {
    fun check(env: ExecutionEnvironment) : Boolean
}
