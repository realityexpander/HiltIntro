package com.example.hiltintro

import android.util.Log
import javax.inject.Inject

class NetworkService @Inject constructor() {
    fun log() {
        Log.d(TAG, "NetworkService: $this")
    }
}