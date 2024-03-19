package com.example.serverinfoviewer.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.serverinfoviewer.R
import com.example.serverinfoviewer.domain.entities.User
import com.example.serverinfoviewer.presentation.diffUtils.UserDiffCallback
import com.example.serverinfoviewer.presentation.viewHolders.UserViewHolder

class UserListAdapter: ListAdapter<User, UserViewHolder>(UserDiffCallback()) {

    var onClickListener: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_card, parent, false)
        view.setOnClickListener {
            onClickListener?.invoke()
        }
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.idField.text = user.id.toString()
        holder.userNameField.text = user.userName
        holder.nameField.text = user.name
        holder.phoneField.text = user.phone
    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE
    }

    companion object {
        const val VIEW_TYPE = 1
    }
}