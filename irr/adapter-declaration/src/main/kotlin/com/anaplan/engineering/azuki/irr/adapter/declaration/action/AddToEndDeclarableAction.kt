package com.anaplan.engineering.azuki.irr.adapter.declaration.action

import com.anaplan.engineering.azuki.irr.adapter.api.AddToEndBehaviour
import com.anaplan.engineering.azuki.irr.adapter.declaration.DeclarableAction
import com.anaplan.engineering.azuki.irr.adapter.declaration.DeclarationBuilder

abstract class AddToEndDeclarableAction(
    protected val name: String,
    protected val value: Double
): AddToEndBehaviour(), DeclarableAction {
    override fun declare(builder: DeclarationBuilder) {
        builder.addToEnd(name, value)
    }
}
