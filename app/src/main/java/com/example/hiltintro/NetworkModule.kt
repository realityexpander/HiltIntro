package com.example.hiltintro

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {

    @Provides
    fun provideNetworkAdapter(): NetworkAdapter {
        return NetworkAdapter.Builder()
            .protocol("HTTPS")
            .host("google.com")
            .build()
    }

    @Provides
    fun networkAdapter2(): NetworkAdapter2 {
        return NetworkAdapter2.Builder()
            .a("hello")
            .b(12)
            .build()
    }
}

class SampleString @Inject constructor() { // provides an instantiation of the class SampleString
    fun getString(): String {
        return "Hello"
    }
}

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {
    @Provides
    @Named("Another String")
    fun provideAnotherString(): String {  // provides just the String
        return "Another Hello"
    }
}