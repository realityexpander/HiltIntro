package com.example.hiltintro

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.example.hiltintro.HiltIntroApplication
import com.example.hiltintro.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var service: NetworkService

    @Inject
    lateinit var adapter: NetworkAdapter

    @Inject
    lateinit var adapter2: NetworkAdapter2

    @Inject
    lateinit var sampleString: SampleString

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)

        service.log()
        adapter.log()
        val hello = (application as HiltIntroApplication)
            .getSampleString()

        findViewById<TextView>(R.id.sample).apply {
            text = hello
        }
        bind.sample.text = "hello 2"

        println((application as HiltIntroApplication).anotherString)
    }
}