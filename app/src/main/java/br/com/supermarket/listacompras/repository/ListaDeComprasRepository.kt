package br.com.supermarket.listacompras.repository

import br.com.supermarket.listacompras.database.dao.ListaDeComprasDao

class ListaDeComprasRepository(private val dao: ListaDeComprasDao) {

    fun buscaTodas() = dao.getAllList()
}