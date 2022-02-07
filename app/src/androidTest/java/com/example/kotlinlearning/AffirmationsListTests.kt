package com.example.kotlinlearning


import android.support.test.espresso.contrib.RecyclerViewActions
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AffirmationsListTests {

    @get:Rule
    val activity = ActivityScenarioRule(Affirmations::class.java)

    @Test
    fun scroll_to_item() {
//        onView(withId(R.id.myRecycleView)).perform(
//            RecyclerViewActions
//                .scrollToPosition<RecyclerView.ViewHolder>(9))

        onView(withId(R.id.myRecycleView)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(8))


        //onView(withText(R.string.affirmation10)).check(matches(isDisplayed()))
    }
}