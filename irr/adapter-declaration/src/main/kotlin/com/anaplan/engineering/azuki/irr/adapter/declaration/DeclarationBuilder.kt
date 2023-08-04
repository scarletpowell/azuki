package com.anaplan.engineering.azuki.irr.adapter.declaration

import com.anaplan.engineering.azuki.declaration.Declaration
import com.anaplan.engineering.azuki.irr.adapter.declaration.declaration.CashFlowSeriesDeclaration
import com.anaplan.engineering.azuki.irr.adapter.declaration.declaration.IrrDeclaration

class DeclarationBuilder(private val declarationActions: List<DeclarableAction>) {
    private val declarations = LinkedHashMap<String, Declaration>()

    private inline fun <reified T : Declaration> getDeclaration(name: String): T =
        declarations[name] as T? ?: throw MissingDeclarationException(name)

    fun build(): List<Declaration> {
        declarationActions.forEach { it.declare(this) }
        return declarations.filter { it.value.standalone }.map { it.value }
    }

    private fun checkForDuplicate(name: String) {
        if (declarations.containsKey(name)) throw DuplicateDeclarationException(name)
    }

    private fun checkExists(name: String) {
        if (!declarations.containsKey(name)) throw MissingDeclarationException(name)
    }

    fun declareCashFlowSeries(cashFlowSeriesName: String) {
        checkForDuplicate(cashFlowSeriesName)
        declarations[cashFlowSeriesName] = CashFlowSeriesDeclaration(cashFlowSeriesName, standalone = true)
    }

    fun addToEnd(cashFlowSeriesName: String, value: Double) {
        val list = getDeclaration<CashFlowSeriesDeclaration>(cashFlowSeriesName)
        declarations[cashFlowSeriesName] = list.copy(
            cashFlows = list.cashFlows + value
        )
    }

    fun declareIrr(irrName: String, cashFlowSeriesName: String){
        checkForDuplicate(irrName)
        declarations[irrName] = IrrDeclaration(irrName, cashFlowSeriesName, standalone = true)
    }
}

class DuplicateDeclarationException(def: String) : IllegalArgumentException("$def is already defined")
class MissingDeclarationException(def: String) : IllegalArgumentException("$def is not defined")
