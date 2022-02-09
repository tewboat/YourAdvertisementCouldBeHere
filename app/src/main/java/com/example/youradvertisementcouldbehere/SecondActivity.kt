package com.example.youradvertisementcouldbehere

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import kotlin.properties.Delegates

class SecondActivity : AppCompatActivity() {
    private val counterKey = "counter"
    private var counter = 0

    private val logTag = "SecondActivity"

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d(logTag, "")
        counter = intent.getIntExtra(counterKey, 0)

        textView = findViewById<TextView?>(R.id.square_text_view)
            .apply { text = (counter * counter).toString() }

        Log.d(logTag, "Activity created")
    }

    override fun onStart() {
        super.onStart()
        Log.d(logTag, "Activity started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(logTag, "Activity resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(logTag, "Activity paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(logTag, "Activity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(logTag, "Activity destroyed")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(counterKey, counter)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        counter = savedInstanceState.getInt(counterKey)
        textView.text = (counter * counter).toString()
    }
}