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
import javax.inject.Named

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

    @Inject
    @Named("StringsModuleString")
    lateinit var stringsModuleString: String

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main) // Cant access DataBindingUtil class
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)

        service.log()
        adapter.log()
        adapter2.log()

        // Get string from Application class function
        val applicationSampleString = (application as HiltIntroApplication)
            .getSampleString()
        println("applicationSampleString= $applicationSampleString")

        // old school binding
        findViewById<TextView>(R.id.sample).apply {
            text = applicationSampleString
        }
        // New school binding
        bind.sample.text = applicationSampleString

        // Get string from Application class
        println((application as HiltIntroApplication).anotherString)

        // Get string from StringsModuleString
        println("StringsModuleString= $stringsModuleString")

        // Get string from SampleString class
        println("sampleString= ${sampleString.getString()}")
    }
}