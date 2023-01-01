package com.areeb.pokedeex.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.areeb.pokedeex.databinding.FragmentHomeBinding
import com.areeb.pokedeex.ui.base.Fragment.BaseFragment
import com.areeb.pokedeex.ui.home.adapter.HomeAdapter
import com.areeb.pokedeex.ui.home.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModels()
    private var _fragmentBinding: FragmentHomeBinding? = null
    private val fragmentBinding get() = _fragmentBinding!!
    private var homeAdapter: HomeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        return _fragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setObserver()
    }

    private fun setObserver() {
        viewModel.pokemonList.observe(viewLifecycleOwner) {
            homeAdapter?.submitList(it)
        }
    }

    private fun init() {
        homeAdapter = context?.let { HomeAdapter(it) }
        fragmentBinding.pokemonRecyclerView.adapter = homeAdapter
    }
}
