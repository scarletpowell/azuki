package com.anaplan.engineering.azuki.irr.dsl.dsl

import com.anaplan.engineering.azuki.core.dsl.Given
import com.anaplan.engineering.azuki.core.system.Action
import com.anaplan.engineering.azuki.irr.adapter.api.IrrActionFactory
import com.anaplan.engineering.azuki.irr.dsl.definition.cashFlowSeriesDefinition
import javax.swing.text.html.parser.Entity

class IrrGiven(private val actionFactory: IrrActionFactory):
    Given<IrrActionFactory>,
    cashFlowSeriesDefinition
{

    private val actionList = mutableListOf<Action>()

    override fun actions(): List<Action> = actionList

    override fun cashFlowSeries(cashFlowSeriesName: String, vararg cashFlows: Double) {
        actionList.add(actionFactory.create(cashFlowSeriesName))
        actionList.addAll(cashFlows.map { actionFactory.addToEnd(cashFlowSeriesName, it)} )
    }

}
