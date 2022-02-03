package com.example.kotlinlearning

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 * unit test for dice activity
 */
class ExampleUnitTest {

    @Test
    fun generates_Numbers() = run {
        val dice = SplashActivity.Dice(6)
        val rollResult = dice.roll()
        assertTrue("the value should was not betwen 1 and 6", rollResult in 1..6)
    }
}



