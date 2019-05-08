package com.jacknic.circleci

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvHello = findViewById<TextView>(R.id.tvHello)
        val versionName = getString(R.string.version_format, BuildConfig.VERSION_NAME)
        tvHello.append(versionName)
    }
}
