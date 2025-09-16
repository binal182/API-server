package com.example.myassssmentapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DashboardAdapter(private val entities: List<Entity>) :
    RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {

    inner class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val course: TextView = view.findViewById(R.id.course)
        val dynamicFieldsContainer: LinearLayout = view.findViewById(R.id.dynamicFieldsContainer)

        init {
            view.setOnClickListener {
                val entity = entities[adapterPosition]
                val intent = Intent(view.context, DetailsActivity::class.java)
                intent.putExtra("ENTITY", HashMap(entity)) // Pass entity to DetailsActivity
                view.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dashboard, parent, false)
        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val entity = entities[position]

        holder.dynamicFieldsContainer.removeAllViews() // Remove old views
        val fieldsToShow = listOf("courseCode", "courseName")
//
        fieldsToShow.forEach { field ->
            val value = entity[field]

            // If the field exists and has a value, create a TextView and add it to the container
            if (value != null) {
                val textView = TextView(holder.itemView.context).apply {
                    text = "$value"
                    setPadding(0, 8, 0, 8)
                }
                holder.dynamicFieldsContainer.addView(textView)
            }
        }



    }

    override fun getItemCount(): Int = entities.size
}