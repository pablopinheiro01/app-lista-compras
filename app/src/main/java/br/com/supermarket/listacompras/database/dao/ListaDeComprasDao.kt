package br.com.supermarket.listacompras.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import br.com.supermarket.listacompras.model.ItemDeCompra

@Dao
interface ListaDeComprasDao {

    @Query("SELECT * FROM compras ORDER BY nome")
    fun getAllList(): LiveData<List<ItemDeCompra>>


}