package com.anaplan.engineering.azuki.irr.adapter.irr.declaration

import com.anaplan.engineering.azuki.declaration.Declaration
import com.anaplan.engineering.azuki.declaration.DeclarationBuilder
import com.anaplan.engineering.azuki.declaration.FeDeclarationBuilderFactory
import com.anaplan.engineering.azuki.irr.adapter.irr.execution.ExecutionEnvironment

interface IRRDeclarationBuilderFactory<D : Declaration> :
    FeDeclarationBuilderFactory<D, IRRDeclarationBuilder<D>>


abstract class IRRDeclarationBuilder<D: Declaration>(declaration: D): DeclarationBuilder<D>(declaration) {

    abstract fun build(env: ExecutionEnvironment)
}
