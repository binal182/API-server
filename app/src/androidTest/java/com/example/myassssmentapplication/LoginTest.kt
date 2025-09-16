package com.example.myassssmentapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class LoginTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testLoginUIElements() {
        // Check if username input is displayed
        onView(withId(R.id.etUsername)).check(matches(isDisplayed()))

        // Check if password input is displayed
        onView(withId(R.id.etPassword)).check(matches(isDisplayed()))

        // Check if login button is displayed
        onView(withId(R.id.btnLogin)).check(matches(withText("Login")))
    }
}

