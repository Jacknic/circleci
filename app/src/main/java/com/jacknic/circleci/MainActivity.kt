package com.jacknic.circleci

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val versionName = getString(R.string.version_format, BuildConfig.VERSION_NAME)
        tvHello.append(versionName)
        tvHello.setOnClickListener {
            tvHello.setText(android.R.string.ok)
        }
    }
}
