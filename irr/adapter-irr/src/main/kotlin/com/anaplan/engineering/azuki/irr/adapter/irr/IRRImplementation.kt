package com.anaplan.engineering.azuki.irr.adapter.irr

import com.anaplan.engineering.azuki.core.system.NoSystemDefaults
import com.anaplan.engineering.azuki.graphs.adapter.api.GraphImplementation

class IRRImplementation : GraphImplementation {
    override val name = "IRR"
    override val total = false
    override val implementationDefaults = NoSystemDefaults
    override fun createSystemFactory(systemDefaults: NoSystemDefaults) = PoiSystemFactory()
}
