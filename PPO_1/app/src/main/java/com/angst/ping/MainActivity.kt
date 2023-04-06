package com.angst.ping

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.angst.ping.components.GameView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(GameView(this))
    }
}