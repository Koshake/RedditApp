package com.koshake1.redditapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.koshake1.redditapp.R
import com.koshake1.redditapp.databinding.FragmentMainBinding
import com.koshake1.redditapp.view.adapter.RedditAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import viewmodel.MainViewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var bindingNullable: FragmentMainBinding? = null

    private val binding get() = bindingNullable!!

    private val mainViewModel: MainViewModel by viewModel()

    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        RedditAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingNullable = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainRecycler.adapter = adapter

        lifecycleScope.launch {
            mainViewModel.fetchData().distinctUntilChanged().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingNullable = null
    }
}