package com.example.myassssmentapplication


import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Before

import org.junit.Rule
import org.junit.Test



class DetailsUITest {
    @get:Rule
    val activityRule = ActivityScenarioRule(DashboardActivity::class.java)

    @Before
    fun setupFakeData() {
        activityRule.scenario.onActivity { activity ->
            val fakeEntities = listOf(
                hashMapOf(
                    "courseCode" to "CS101",
                    "courseName" to "Intro to Programming",
                    "instructor" to "Dr. Smith",
                    "credits" to 3,
                    "description" to "Basic programming concepts"
                )
            )

            val adapter = DashboardAdapter(fakeEntities)
            activity.findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter
        }
    }

    @Test
    fun testNavigateToDetails() {
        // Click first item in RecyclerView
        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        // Check Details screen is displayed
        onView(withId(R.id.details)).check(matches(isDisplayed()))
    }
}
