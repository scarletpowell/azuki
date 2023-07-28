package com.anaplan.engineering.azuki.irr.dsl.dsl

import com.anaplan.engineering.azuki.core.dsl.DslProvider
import com.anaplan.engineering.azuki.core.dsl.NoGenerate
import com.anaplan.engineering.azuki.core.dsl.NoQueries
import com.anaplan.engineering.azuki.core.dsl.NoVerify
import com.anaplan.engineering.azuki.core.system.NoActionGeneratorFactory
import com.anaplan.engineering.azuki.core.system.NoQueryFactory
import com.anaplan.engineering.azuki.irr.adapter.api.IrrActionFactory
import com.anaplan.engineering.azuki.irr.adapter.api.IrrCheckFactory

object IrrDslProvider : DslProvider<
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
    IrrRegardlessOf
    > {
    override fun createGiven(actionFactory: IrrActionFactory) = IrrGiven(actionFactory)

    override fun createWhen(actionFactory: IrrActionFactory) = IrrWhen(actionFactory)

    override fun createThen(checkFactory: IrrCheckFactory) = IrrThen(checkFactory)

    override fun createVerify(queryFactory: NoQueryFactory) = NoVerify

    override fun createQueries(queryFactory: NoQueryFactory) = NoQueries

    override fun createGenerate(actionGeneratorFactory: NoActionGeneratorFactory) = NoGenerate

    override fun createRegardlessOf(actionFactory: IrrActionFactory) = IrrRegardlessOf(actionFactory)
}

