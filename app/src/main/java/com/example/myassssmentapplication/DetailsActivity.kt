package com.example.myassssmentapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailsActivity : AppCompatActivity() {

    lateinit var details: LinearLayout

    private val fieldsOrder = listOf("instructor", "credits")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Enable back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Details"

        details = findViewById(R.id.details)

        val entity = intent.getSerializableExtra("ENTITY") as? HashMap<*, *>

        entity?.let {
            val courseCode = it["courseCode"] as? String ?: "N/A"
            val courseName = it["courseName"] as? String ?: "N/A"
            val courseTextView = TextView(this).apply {
                text = "$courseCode $courseName"
                textSize = 20f
                setPadding(0, 16, 0, 8) // Add padding to separate from next field
            }
            details.addView(courseTextView)

            val description = it["description"] as? String ?: "No description available"
            val descriptionTextView = TextView(this).apply {
                text = description
                textSize = 16f
                setPadding(0, 8, 0, 16) // Add padding to separate from next field
            }
            details.addView(descriptionTextView)

            fieldsOrder.forEach { field ->
                val value = it[field] ?: "N/A"
                val displayName =  field.replaceFirstChar { it.uppercaseChar() }
                val textView = TextView(this).apply {
                    text = "$displayName: $value"
                    textSize = 16f
                    setPadding(0, 8, 0, 8)
                }
                details.addView(textView)
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish() // Go back
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
