package br.com.supermarket.listacompras.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import br.com.supermarket.listacompras.database.AppDatabase
import br.com.supermarket.listacompras.database.dao.ListaDeComprasDao
import br.com.supermarket.listacompras.model.ItemDeCompra
import br.com.supermarket.listacompras.repository.ListaDeComprasRepository
import br.com.supermarket.listacompras.ui.adapter.HomeFragmentAdapter
import br.com.supermarket.listacompras.ui.viewmodel.ListaDeComprasViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val NOME_BASE = "lista_de_compras.db"


val dbModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            NOME_BASE
        ).addCallback(
            object : RoomDatabase.Callback(){
                override fun onCreate(db: SupportSQLiteDatabase) {
                    CoroutineScope(IO).launch {
                        val dao: ListaDeComprasDao by inject()
                        repeat(10){
                            dao.insertData(
                                ItemDeCompra(
                                    nome = "teste "+it,
                                    quantidade = 12,
                                    valor = 100.0+it,
                                    dataDeGravacao = "12/07/2021"
                                )
                            )
                        }
                    }
                }
            }).build()
    }
}

val daoModule = module {
    single{
        get<AppDatabase>().dao
    }
}

val uiModule = module{
    factory<HomeFragmentAdapter>{ HomeFragmentAdapter(get()) }
}

val viewModule = module {
    viewModel<ListaDeComprasViewModel>{ ListaDeComprasViewModel(get()) }
}

val repositoryModule = module {
    single<ListaDeComprasRepository>{ ListaDeComprasRepository(get()) }
}

val modulePrincipal = listOf(dbModule, daoModule, uiModule, viewModule, repositoryModule)