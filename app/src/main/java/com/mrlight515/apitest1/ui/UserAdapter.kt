package com.mrlight515.apitest1.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mrlight515.apitest1.databinding.ListItemBinding
import com.mrlight515.apitest1.network.UserCard

class UserAdapter : ListAdapter<UserCard,
        UserAdapter.UserViewHolder>(DiffCallback) {


    class UserViewHolder(
        private var binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(UserCard: UserCard) {
            binding.userCard = UserCard
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<UserCard>() {
        override fun areItemsTheSame(oldItem: UserCard, newItem: UserCard): Boolean {
            return oldItem.userName == newItem.userName
        }

        override fun areContentsTheSame(oldItem: UserCard, newItem: UserCard): Boolean {
            return oldItem.userPhoto == newItem.userPhoto
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val userCard = getItem(position)
        holder.bind(userCard)
    }

}