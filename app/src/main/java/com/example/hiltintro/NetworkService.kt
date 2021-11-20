package com.example.hiltintro

import android.util.Log
import javax.inject.Inject

class NetworkService @Inject constructor() {  // provides an instantiation of the class NetworkService
    fun log() {
        Log.d(TAG, "NetworkService: $this")
    }
}