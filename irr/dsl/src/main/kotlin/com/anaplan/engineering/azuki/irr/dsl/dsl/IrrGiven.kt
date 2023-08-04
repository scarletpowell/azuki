package com.anaplan.engineering.azuki.irr.dsl.dsl

import com.anaplan.engineering.azuki.core.dsl.Given
import com.anaplan.engineering.azuki.core.system.Action
import com.anaplan.engineering.azuki.irr.adapter.api.IrrActionFactory
import com.anaplan.engineering.azuki.irr.dsl.definition.CashFlowSeriesDefinition
import com.anaplan.engineering.azuki.irr.dsl.definition.IrrDefinition

class IrrGiven(private val actionFactory: IrrActionFactory):
    Given<IrrActionFactory>,
    CashFlowSeriesDefinition,
    IrrDefinition
{

    private val actionList = mutableListOf<Action>()

    override fun actions(): List<Action> = actionList

    override fun cashFlowSeries(cashFlowSeriesName: String, vararg cashFlows: Double) {
        actionList.add(actionFactory.cashFlowSeries.create(cashFlowSeriesName))
        actionList.addAll(cashFlows.map { actionFactory.cashFlowSeries.addToEnd(cashFlowSeriesName, it)} )
    }

    override fun thereIsAnIrr(irrName: String, cashFlowSeriesName: String) {

    }

}
