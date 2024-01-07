package com.omar.jsonplaceholder_android.fragments.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.omar.jsonplaceholder_android.databinding.FragmentPostBinding
import com.omar.jsonplaceholder_android.models.PostModel


class PostFragment : Fragment() {

    private lateinit var binding: FragmentPostBinding
    private lateinit var post: PostModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            com.omar.jsonplaceholder_android.R.layout.fragment_post,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPostBinding.bind(view)
        loadDataFromIntent()
    }

    private fun loadDataFromIntent() {
        arguments?.let {
            if (it.containsKey(POST_INTENT_EXTRA)) {
                post = it.getSerializable(POST_INTENT_EXTRA) as PostModel
                fillData()
            }
        }
    }

    private fun fillData() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = post.title
        binding.postId.text = post.id.toString()
        binding.userId.text = post.userId.toString()
        binding.postBody.text = post.body
    }

    companion object {

        val POST_INTENT_EXTRA = "Post"
    }
}