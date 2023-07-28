package com.anaplan.engineering.azuki.irr.adapter.declaration.declaration

import com.anaplan.engineering.azuki.declaration.Declaration

data class CashFlowSeriesDeclaration(
    override val name: String,
    val cashFlows: List<Double> = emptyList(),
    override val standalone: Boolean
): Declaration
