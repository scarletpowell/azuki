package com.anaplan.engineering.azuki.irr.adapter.irr.declaration

import com.anaplan.engineering.azuki.irr.adapter.declaration.declaration.IrrDeclaration
import com.anaplan.engineering.azuki.irr.adapter.irr.execution.ExecutionEnvironment


class CreateIrrDeclarationBuilderFactory : IrrPoiDeclarationBuilderFactory<IrrDeclaration> {

    override val declarationClass = IrrDeclaration::class.java

    override fun create(declaration: IrrDeclaration): IrrPoiDeclarationBuilder<IrrDeclaration> =
        IrrDeclarationBuilder(declaration)

    private class IrrDeclarationBuilder(declaration: IrrDeclaration) :
        IrrPoiDeclarationBuilder<IrrDeclaration>(declaration) {

        override fun build(env: ExecutionEnvironment) {
            // - fetch cash flow list from env (name in declaration)
            // - (alternative) have a declaration getter for the list in the IRR declaration and use that directly
            // - (alternative) do without an explicit cash flow list and just store the values in the IRR declaration
            // - calculate IRR of that list of values using library
            // - store calculated IRR value in env
            TODO()
        }

    }
}
