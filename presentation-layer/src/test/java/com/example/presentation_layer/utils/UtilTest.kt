package com.example.presentation_layer.utils

import org.junit.Assert.*
import org.junit.Test

class UtilTest {
    @Test
    fun `check introvert or extrovert`() {
        assertTrue(Util.getFinalResult(1) == "Introvert")
        assertTrue(Util.getFinalResult(2) == "Extrovert")
        assertTrue(Util.getFinalResult(10) == "Extrovert")
        assertTrue(Util.getFinalResult(18) == "Extrovert")
        assertTrue(Util.getFinalResult(9) == "Introvert")
        assertTrue(Util.getFinalResult(5) == "Introvert")
        assertTrue(Util.getFinalResult(7) == "Introvert")
        assertTrue(Util.getFinalResult(15) == "Introvert")


    }
}