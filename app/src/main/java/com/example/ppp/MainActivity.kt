package com.example.ppp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun openStage1(view: View) {
        val intent = Intent(this, Stage1Activity::class.java)
        startActivity(intent)
    }
}