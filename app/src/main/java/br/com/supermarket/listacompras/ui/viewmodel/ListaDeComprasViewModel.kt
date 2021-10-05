package br.com.supermarket.listacompras.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.supermarket.listacompras.model.ItemDeCompra
import br.com.supermarket.listacompras.repository.ListaDeComprasRepository

class ListaDeComprasViewModel(private val repository: ListaDeComprasRepository): ViewModel() {

    val todas: LiveData<List<ItemDeCompra>> = repository.buscaTodas()
}