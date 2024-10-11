package com.vkclient.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.core.network.di.NetworkModule
import com.core.network.di.viewModel.ViewModelFactoryModule
import com.core.network.di.viewModel.ViewModelModule
import com.core.util.scope.AppScope
import com.vkclient.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [
        NetworkModule::class,
        AppModule::class,
        ViewModelModule::class,
        ViewModelFactoryModule::class,
    ],
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun getViewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            context: Application,
        ): AppComponent
    }
}
