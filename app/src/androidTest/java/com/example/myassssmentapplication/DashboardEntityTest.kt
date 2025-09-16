package com.example.myassssmentapplication

import org.junit.Assert.assertEquals
import org.junit.Test

class DashboardEntityTest {
    @Test
    fun testEntityParsing() {
        val entity = hashMapOf(
            "courseCode" to "CS101",
            "courseName" to "Intro to Programming",
            "instructor" to "Dr. Smith",
            "credits" to 3,
            "description" to "Basic programming concepts"
        )

        assertEquals("CS101", entity["courseCode"])
        assertEquals("Intro to Programming", entity["courseName"])
        assertEquals("Dr. Smith", entity["instructor"])
        assertEquals(3, entity["credits"])
    }
}
