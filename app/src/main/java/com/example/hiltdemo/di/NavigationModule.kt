package com.example.hiltdemo.di

import com.example.hiltdemo.navigator.AppNavigator
import com.example.hiltdemo.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {
    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator
}