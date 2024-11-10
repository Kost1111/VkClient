package com.feature.feed.impl.ui

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class FeedViewModel @Inject constructor(

) : ViewModel() {
    fun getLog() = "log ${this.hashCode()}"
}