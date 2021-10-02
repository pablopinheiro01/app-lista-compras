package br.com.supermarket.listacompras.di

import androidx.room.Room
import br.com.supermarket.listacompras.database.AppDatabase
import org.koin.dsl.module

private const val NOME_BASE = "lista_de_compras.db"


val dbModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            NOME_BASE
        ).build()
    }
}

val daoModule = module {
    single{
        get<AppDatabase>().dao
    }
}

val modulePrincipal = listOf(dbModule, daoModule)