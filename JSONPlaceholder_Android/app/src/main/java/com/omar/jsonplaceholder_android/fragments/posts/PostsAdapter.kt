package com.omar.jsonplaceholder_android.fragments.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.omar.jsonplaceholder_android.R
import com.omar.jsonplaceholder_android.models.PostModel

class PostsAdapter(val posts: List<PostModel>, val onItemClicked: (PostModel) -> Unit) :
    RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {


    class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postTitleTextView: TextView = itemView.findViewById(R.id.post_title)
        val postBody: TextView = itemView.findViewById(R.id.post_body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.post_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val postModel = posts[position]
        holder.postTitleTextView.text = postModel.title
        holder.postBody.text = postModel.body

        holder.itemView.setOnClickListener {
            onItemClicked(postModel)
        }
    }
}