package com.feature.profile.impl.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feature.profile.api.repository.IProfileRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val profileRepository: IProfileRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            profileRepository.getProfile()
                .onSuccess { profile ->
                    Log.i("TEST1", "${profile.items}")
                }
                .onFailure {
                    Log.i("TEST1", "${it.message}")
                }
        }
    }
}

