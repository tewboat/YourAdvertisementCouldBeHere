package com.example.youradvertisementcouldbehere

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class FirstActivity : AppCompatActivity() {

    private var counter = 0
    private val counterKey = "counter"

    private val logTag = "FirstActivity"

    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        textView = findViewById<TextView?>(R.id.counter_text_view)
            .apply { text = counter.toString() }
        button = findViewById(R.id.to_second_activity)
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
                .apply { putExtra(counterKey, counter) }
            startActivity(intent)
        }

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
        outState.putInt(counterKey, counter + 1)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        counter = savedInstanceState.getInt(counterKey)
        textView.text = counter.toString()
    }
}