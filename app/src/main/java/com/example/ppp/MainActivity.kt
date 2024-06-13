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
    public fun openStage2(view: View) {
        val intent = Intent(this, Stage2Activity::class.java)
        startActivity(intent)
    }
    public fun openStage3(view: View) {
        val intent = Intent(this, Stage3Activity::class.java)
        startActivity(intent)
    }
    public fun openStage4(view: View) {
        val intent = Intent(this, Stage4Activity::class.java)
        startActivity(intent)
    }
    public fun openStage5(view: View) {
        val intent = Intent(this, Stage5Activity::class.java)
        startActivity(intent)
    }
    public fun openStage6(view: View) {
        val intent = Intent(this, Stage5Activity::class.java)
        startActivity(intent)
    }
    public fun openStage7(view: View) {
        val intent = Intent(this, Stage5Activity::class.java)
        startActivity(intent)
    }
    public fun openStage8(view: View) {
        val intent = Intent(this, Stage5Activity::class.java)
        startActivity(intent)
    }
    public fun openStage9(view: View) {
        val intent = Intent(this, Stage5Activity::class.java)
        startActivity(intent)
    }
    public fun openStage10(view: View) {
        val intent = Intent(this, Stage5Activity::class.java)
        startActivity(intent)
    }
}