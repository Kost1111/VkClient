package com.vkclient.di

import android.app.Application
import android.content.Context
import com.core.network.di.NetworkModule
import com.vkclient.MainActivity
import com.core.network.di.viewModel.ViewModelFactoryModule
import com.core.network.di.viewModel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        AppModule::class,
        ViewModelModule::class,
        ViewModelFactoryModule::class],
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            context: Application,
        ): AppComponent
    }
}
