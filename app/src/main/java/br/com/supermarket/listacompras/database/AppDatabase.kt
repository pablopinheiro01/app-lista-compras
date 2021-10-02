package br.com.supermarket.listacompras.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.supermarket.listacompras.database.dao.ListaDeComprasDao
import br.com.supermarket.listacompras.model.ItemDeCompra

@Database(version = 1, exportSchema = false, entities = [ItemDeCompra::class])
abstract class AppDatabase : RoomDatabase(){

    abstract val dao: ListaDeComprasDao
}