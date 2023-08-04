package com.anaplan.engineering.azuki.irr.adapter.irr.action

import com.anaplan.engineering.azuki.core.system.Action
import com.anaplan.engineering.azuki.irr.adapter.api.CashFlowSeriesActionFactory
import com.anaplan.engineering.azuki.irr.adapter.api.IrrActionFactory
import com.anaplan.engineering.azuki.irr.adapter.api.IrrValueActionFactory
import com.anaplan.engineering.azuki.irr.adapter.irr.execution.ExecutionEnvironment


class IrrPoiActionFactory : IrrActionFactory {
    override val cashFlowSeries = PoiCashFlowSeriesActionFactory()
    override val irr = PoiIrrValueActionFactory()
}

class PoiCashFlowSeriesActionFactory: CashFlowSeriesActionFactory {
    override fun create(cashFlowSeriesName: String) = CreateCashFlowSeriesAction(cashFlowSeriesName)
    override fun addToEnd(cashFlowSeriesName: String, cashFlow: Double): Action = AddToEndAction(cashFlowSeriesName,cashFlow)
}

class PoiIrrValueActionFactory: IrrValueActionFactory {

}
interface IRRAction : Action {

    fun act(env: ExecutionEnvironment)

}

val toIRRAction: (Action) -> IRRAction = {
    it as? IRRAction ?: throw IllegalArgumentException("Invalid action: $it")
}
