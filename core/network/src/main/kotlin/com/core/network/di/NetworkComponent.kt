package com.core.network.di

import dagger.Subcomponent

@Subcomponent(
    modules = [NetworkModule::class]
)
interface NetworkComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NetworkComponent
    }
}