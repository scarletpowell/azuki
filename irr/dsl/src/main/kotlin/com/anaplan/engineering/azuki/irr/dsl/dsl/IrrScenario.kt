package com.anaplan.engineering.azuki.irr.dsl.dsl

import com.anaplan.engineering.azuki.core.dsl.NoGenerate
import com.anaplan.engineering.azuki.core.dsl.NoQueries
import com.anaplan.engineering.azuki.core.dsl.NoVerify
import com.anaplan.engineering.azuki.core.runner.RunnableScenario
import com.anaplan.engineering.azuki.core.system.NoActionGeneratorFactory
import com.anaplan.engineering.azuki.core.system.NoQueryFactory
import com.anaplan.engineering.azuki.core.system.NoSystemDefaults
import com.anaplan.engineering.azuki.irr.adapter.api.IrrActionFactory
import com.anaplan.engineering.azuki.irr.adapter.api.IrrCheckFactory

open class IrrScenario : RunnableScenario<
    IrrActionFactory,
    IrrCheckFactory,
    NoQueryFactory,
    NoActionGeneratorFactory,
    IrrGiven,
    IrrWhen,
    IrrThen,
    NoVerify,
    NoQueries,
    NoGenerate,
    IrrRegardlessOf,
    NoSystemDefaults>(IrrDslProvider)
