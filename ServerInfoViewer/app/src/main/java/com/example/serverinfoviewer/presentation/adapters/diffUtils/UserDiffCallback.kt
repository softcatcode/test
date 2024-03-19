package com.example.serverinfoviewer.presentation.adapters.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.serverinfoviewer.domain.entities.User

class UserDiffCallback: DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}