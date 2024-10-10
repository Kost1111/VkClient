package com.feature.feed.impl.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.feature.feed.impl.di.DaggerFeedComponent
import javax.inject.Inject

class FeedViewModel @Inject constructor(

) : ViewModel() {

    val feedComponent = DaggerFeedComponent.factory().create()


    init {
        Log.i("tag1", "govno ${this}")
    }

    fun getLog() = "log ${this.hashCode()}"

}