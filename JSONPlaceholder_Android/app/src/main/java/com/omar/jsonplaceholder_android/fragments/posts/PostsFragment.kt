package com.omar.jsonplaceholder_android.fragments.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.omar.jsonplaceholder_android.R
import com.omar.jsonplaceholder_android.databinding.FragmentPostsBinding
import com.omar.jsonplaceholder_android.fragments.post.PostFragment
import com.omar.jsonplaceholder_android.models.PostModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsFragment : Fragment() {

    private lateinit var viewModel: PostsViewModel
    private lateinit var binding: FragmentPostsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPostsBinding.bind(view)
        viewModel = ViewModelProvider(this)[PostsViewModel::class.java]
        handleBackButton()
        requireActivity().title = getString(R.string.items)
        observe()
        loadPosts()
    }

    private fun handleBackButton() {
        val menuHost: MenuHost = requireActivity()

        // Add menu items without using the Fragment Menu APIs
        // Note how we can tie the MenuProvider to the viewLifecycleOwner
        // and an optional Lifecycle.State (here, RESUMED) to indicate when
        // the menu should be visible
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
//                menuInflater.inflate(R.menu.example_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                if (menuItem.itemId == android.R.id.home) {
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun observe() {
        viewModel.postsLiveData.observe(requireActivity()) {
            if (it.isNullOrEmpty()) {
                Toast.makeText(requireContext(), getString(R.string.no_items), Toast.LENGTH_LONG)
                    .show()
            } else {
                fillRecyclerView(it)
            }
        }

        viewModel.error.observe(requireActivity()) {
            Toast.makeText(requireContext(), getString(R.string.no_internet), Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun loadPosts() {
        viewModel.loadPosts()
    }

    private fun fillRecyclerView(posts: List<PostModel>) {
        val postsAdapter = PostsAdapter(posts) {
            navigateToPostFragment(it)
        }
        binding.postsRecyclerview.adapter = postsAdapter
    }

    private fun navigateToPostFragment(postModel: PostModel) {
        findNavController().currentDestination?.getAction(R.id.posts_post_action)?.let {
            val bundle = Bundle()
            bundle.putSerializable(PostFragment.POST_INTENT_EXTRA, postModel)
            binding.root.findNavController()
                .navigate(R.id.posts_post_action, bundle)
        }
    }
}