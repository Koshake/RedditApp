package com.koshake1.redditapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.koshake1.redditapp.R
import com.koshake1.redditapp.databinding.ItemMainBinding
import com.koshake1.redditapp.model.data.Children

class RedditAdapter : PagingDataAdapter<Children, RedditAdapter.RedditViewHolder>(COMPARATOR) {

    override fun onBindViewHolder(holder: RedditViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditViewHolder {
        return RedditViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_main,
            parent,
            false))
    }

    inner class RedditViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMainBinding.bind(itemView)

        fun bind(data: Children?) {
            with(binding) {
                textviewText.text = data?.data?.title
                textviewMsg.text = data?.data?.num_comments.toString()
                textviewStar.text = data?.data?.total_awards_received.toString()
            }
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Children>() {
            override fun areItemsTheSame(oldItem: Children, newItem: Children): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Children, newItem: Children): Boolean =
                oldItem == newItem
        }
    }
}