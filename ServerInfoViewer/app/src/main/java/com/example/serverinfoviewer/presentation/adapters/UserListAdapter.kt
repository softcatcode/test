package com.example.serverinfoviewer.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.serverinfoviewer.R
import com.example.serverinfoviewer.domain.entities.User
import com.example.serverinfoviewer.presentation.adapters.diffUtils.UserDiffCallback
import com.example.serverinfoviewer.presentation.adapters.viewHolders.UserViewHolder

class UserListAdapter: ListAdapter<User, UserViewHolder>(UserDiffCallback()) {

    var onClickListener: ((User) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_card, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.idField.text = user.id.toString()
        holder.userNameField.text = user.userName
        holder.nameField.text = user.name
        holder.phoneField.text = user.phone
        holder.view.setOnClickListener {
            onClickListener?.invoke(user)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE
    }

    companion object {
        const val VIEW_TYPE = 1
    }
}