package com.feature.profile.impl.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feature.profile.api.repository.IProfileRepository
import com.feature.profile.impl.data.api.ProfileRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val profileRepository: IProfileRepository
) : ViewModel()
{


    init {
        Log.i("tag1", "gei")
        viewModelScope.launch {
           val profile =  profileRepository.getProfile("vk1.a.oRa62OPmJFUq-gDQ_IamrabFesXzCrAVntD0s15nMVJ9nJKBJqYvHoKjJTatBJVtXBThAb0XZKZpPt-m99JhYEe_V6Jdcved0APaHgRz8KfU8Pj_HOb1PVsSINUINf8xzUGR_U4tcUZO8NchuyGLC59wtlYngZ2qW1eMv8BR3gm_QLszg9GSoVO_ScPnCPELzrNkCJNhZKZxId6ho1M25g")
            Log.i("tag1", "${profile.items}")
        }
    }
}

