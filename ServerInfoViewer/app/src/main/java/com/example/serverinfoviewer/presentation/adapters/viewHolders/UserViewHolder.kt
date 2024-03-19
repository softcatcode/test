package com.example.serverinfoviewer.presentation.adapters.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.serverinfoviewer.R

class UserViewHolder(val view: View): ViewHolder(view) {
    val idField = view.findViewById<TextView>(R.id.id_field)
    val userNameField = view.findViewById<TextView>(R.id.user_name_field)
    val nameField = view.findViewById<TextView>(R.id.name_field)
    val phoneField = view.findViewById<TextView>(R.id.phone_field)
}