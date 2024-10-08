package com.vkclient.di

import android.app.Application
import com.core.network.di.NetworkModule
import com.vkclient.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class, AppModule::class],
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance fun context(context: Application): Builder

        @BindsInstance fun app(app: Application): Builder
        fun build(): AppComponent
    }
}
