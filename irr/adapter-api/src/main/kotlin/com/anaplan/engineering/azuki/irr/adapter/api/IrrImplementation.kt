package com.anaplan.engineering.azuki.irr.adapter.api

import com.anaplan.engineering.azuki.core.system.Implementation
import com.anaplan.engineering.azuki.core.system.NoActionGeneratorFactory
import com.anaplan.engineering.azuki.core.system.NoQueryFactory
import com.anaplan.engineering.azuki.core.system.NoSystemDefaults

interface IrrImplementation: Implementation<
    IrrActionFactory,
    IrrCheckFactory,
    NoQueryFactory,
    NoActionGeneratorFactory,
    NoSystemDefaults> {
}
