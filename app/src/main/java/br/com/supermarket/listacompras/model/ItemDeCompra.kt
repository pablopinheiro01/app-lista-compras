package br.com.supermarket.listacompras.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "compras")
data class ItemDeCompra(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nome: String,
    val quantidade: Int,
    val valor: Double,
    val dataDeGravacao: String
) {
}