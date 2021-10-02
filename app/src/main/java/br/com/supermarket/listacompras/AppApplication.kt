package br.com.supermarket.listacompras

import android.app.Application
import br.com.supermarket.listacompras.di.modulePrincipal
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(modulePrincipal)
        }
    }

}