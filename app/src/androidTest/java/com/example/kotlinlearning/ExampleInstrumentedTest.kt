package com.example.kotlinlearning

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matchers.containsString
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches as matches1

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.kotlinlearning", appContext.packageName)
    }
}
@RunWith(AndroidJUnit4::class)
class CalculatorTest{
    @get:Rule()
    val activity = ActivityScenarioRule(CalculatorTips::class.java)

    @Test
    fun calculate_20_percent_tip(){
        onView(withId(R.id.cost_of_service_editText))
            .perform(typeText("50.00"))

        onView(withId(R.id.mButtonTwo)).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("10.00"))))

    }
}
