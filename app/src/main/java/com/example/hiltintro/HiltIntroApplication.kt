package com.example.hiltintro

import android.app.Application
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import javax.inject.Named

const val TAG = "HiltIntroTag"

@HiltAndroidApp
class HiltIntroApplication: Application() { // this is an ApplicationComponent

    @Inject
    @Named("Another String")
    lateinit var anotherString: String

    @Inject
    lateinit var sampleString: SampleString

    fun getSampleString(): String {
        return sampleString.getString()
    }

    fun anotherString(): String {
        return anotherString
    }

}