package com.feature.feed.impl.di

import androidx.lifecycle.ViewModel
import com.core.network.di.viewModel.ViewModelKey
import com.feature.feed.impl.ui.FeedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FeedViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FeedViewModel::class)
    fun bindFeedViewModel(viewModel: FeedViewModel): ViewModel

}