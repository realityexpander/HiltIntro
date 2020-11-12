package com.example.hiltintro

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

const val TAG = "HiltIntroTag"

@HiltAndroidApp
class HiltIntroApplication: Application() {
}