package com.core.util.compose.navigation

import androidx.navigation.NamedNavArgument
import com.core.util.scope.AppScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

enum class NavigationActions {
    BACK,
    FORWARD,
    REPLACE,
    REPLACE_CURRENT,
}

data class NavigationCommand(
    val actions: NavigationActions,
    val destination: String? = null,
    val arguments: List<NamedNavArgument> = emptyList(),
)

@AppScope
class NavigationManager @Inject constructor() {
    private val _commands = MutableSharedFlow<NavigationCommand>(
        replay = 1,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val commands: SharedFlow<NavigationCommand> = _commands.asSharedFlow()

    fun navigateTo(direction: String) {
        val command = NavigationCommand(NavigationActions.FORWARD, direction)
        _commands.tryEmit(command)
    }

    fun back() {
        _commands.tryEmit(NavigationCommand(NavigationActions.BACK))
    }

    fun backTo(direction: String) {
        _commands.tryEmit(NavigationCommand(NavigationActions.BACK, direction))
    }

    fun replace(direction: String) {
        _commands.tryEmit(NavigationCommand(NavigationActions.REPLACE, direction))
    }

    fun replaceCurrent(direction: String) {
        _commands.tryEmit(NavigationCommand(NavigationActions.REPLACE_CURRENT, direction))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun resetCache() {
        _commands.resetReplayCache()
    }
}