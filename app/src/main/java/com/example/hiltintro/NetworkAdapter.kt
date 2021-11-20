package com.example.hiltintro

import android.util.Log

class NetworkAdapter private constructor(builder: Builder){

    private val protocol: String?
    private val host: String?

    init {
        this.protocol = builder.protocol
        this.host = builder.host
    }

    fun log() {
        Log.d(TAG, "NetworkAdapter: $this, protocol: $protocol, host: $host")
    }

    class Builder {
        var protocol: String? = null
            private set
        var host: String? = null
            private set

        fun protocol(protocol: String) = apply { this.protocol = protocol }
        fun host(host: String) = apply { this.host = host }
        fun build() = NetworkAdapter(this)
    }
}

// More kotlin style builder (even though named components work best)
class NetworkAdapter2(private val a: String? = null,
                      private val b: Int? = null) {

    fun log() {
        Log.d(TAG, "NetworkAdapter2: $this, a=$a, b=$b")
    }

    class Builder {
        private var a: String? = null
        private var b: Int? = null

        fun a(a:String) = apply { this.a = a }
        fun b(b:Int) = apply { this.b = b }
        fun build() = NetworkAdapter2(this.a, this.b)
    }
}