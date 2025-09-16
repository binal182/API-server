package com.example.myassssmentapplication

import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches


class DashboardUITest {
    @get:Rule
    val activityRule = ActivityScenarioRule(DashboardActivity::class.java)

    @Test
    fun testRecyclerViewDisplayed() {
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }
}