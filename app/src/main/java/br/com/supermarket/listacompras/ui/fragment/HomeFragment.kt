package br.com.supermarket.listacompras.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.supermarket.listacompras.databinding.HomeFragmentBinding
import br.com.supermarket.listacompras.ui.adapter.HomeFragmentAdapter
import br.com.supermarket.listacompras.ui.viewmodel.ListaDeComprasViewModel
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment: Fragment() {

    val view: ListaDeComprasViewModel by viewModel()
    val listaAdapter: HomeFragmentAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = HomeFragmentBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.recyclerViewHome.adapter = listaAdapter



        view.todas.observe(requireActivity(), Observer {
            listaAdapter.submitList(it)
        })

        return binding.root
    }
}