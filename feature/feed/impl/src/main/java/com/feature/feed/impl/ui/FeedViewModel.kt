package com.feature.feed.impl.ui

import androidx.lifecycle.ViewModel
import com.feature.feed.impl.di.DaggerFeedComponent
import javax.inject.Inject

class FeedViewModel @Inject constructor(

) : ViewModel() {

    val feedComponent = DaggerFeedComponent.factory().create()

    fun getLog() = "log ${this.hashCode()}"

}