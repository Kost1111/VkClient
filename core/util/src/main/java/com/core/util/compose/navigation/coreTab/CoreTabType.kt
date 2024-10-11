package com.core.util.compose.navigation.coreTab

import dagger.MapKey

enum class CoreTabType {
    FEED_TAB,
}

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class CoreTabKey(val value: CoreTabType)