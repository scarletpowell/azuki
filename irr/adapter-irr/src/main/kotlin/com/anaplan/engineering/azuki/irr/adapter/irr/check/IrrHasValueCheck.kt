package com.anaplan.engineering.azuki.irr.adapter.irr.check

import com.anaplan.engineering.azuki.irr.adapter.irr.execution.ExecutionEnvironment
import com.anaplan.engineering.azuki.irr.adapter.irr.execution.ExecutionException
import org.slf4j.LoggerFactory

class IrrHasValueCheck(private val irrName: String, private val expected: Double): IrrPoiCheck{
    override val behavior = -1
    override fun check(env: ExecutionEnvironment): Boolean{
        val actual = env.irrValues[irrName] ?: throw ExecutionException("No such irr $irrName")
        val result = expected == actual
        if (!result) {
            Log.error("Expected:\n$expected\nActual:\n$actual")
        }
        return result
    }

    companion object {
        private val Log = LoggerFactory.getLogger(this::class.java)
    }
}
