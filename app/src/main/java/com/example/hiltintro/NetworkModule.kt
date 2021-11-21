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

@Module
@InstallIn(ActivityComponent::class) // Put into any Activity component
class StringsModule {
    @Provides
    @Named("StringsModuleString")
    fun provideStringsModuleString(): String {  // provides just the String
        return "StringsModuleString Hello"
    }
}

// provides an instance of the CLASS (not just the function, or the string)
class SampleString @Inject constructor() { // provides an instantiation of the Class SampleString, CANNOT use @Named here!
    fun getString(): String {
        return "SampleString Hello"
    }
}

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {
    @Provides
    @Named("Another String")
    fun provideAnotherString(): String {  // provides JUST the String
        return "Another Hello"
    }
}