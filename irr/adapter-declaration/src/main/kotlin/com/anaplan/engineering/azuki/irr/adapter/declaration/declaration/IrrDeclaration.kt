package com.anaplan.engineering.azuki.irr.adapter.declaration.declaration

import com.anaplan.engineering.azuki.declaration.Declaration

data class IrrDeclaration(
    override val name: String,
    val cashflow: Double,
    override val standalone: Boolean,
): Declaration
