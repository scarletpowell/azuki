package com.anaplan.engineering.azuki.irr.adapter.irr.check

import com.anaplan.engineering.azuki.core.system.Behavior
import com.anaplan.engineering.azuki.core.system.Check
import com.anaplan.engineering.azuki.irr.adapter.api.IrrCheckFactory
import com.anaplan.engineering.azuki.irr.adapter.irr.execution.ExecutionEnvironment

class IrrPoiCheckFactory: IrrCheckFactory {
    override fun systemValid() = IrrSystemValidCheck
}

object IrrSystemValidCheck : IrrPoiCheck {
    override val behavior = -1
    override fun check(env: ExecutionEnvironment) = true
}

interface IrrPoiCheck : Check {
    fun check(env: ExecutionEnvironment) : Boolean
}

val toIrrPoiCheck: (Check) -> IrrPoiCheck = {
    @Suppress("UNCHECKED_CAST")
    it as? IrrPoiCheck ?: throw IllegalArgumentException("Invalid check: $it")
}
