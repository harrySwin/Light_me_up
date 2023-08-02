package com.example.lightmeup

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val key : ImageButton = findViewById<ImageButton>(R.id.key_btn)
        val lock : ImageView = findViewById<ImageView>(R.id.lock)
        lock.setTag("closed")
        key.setOnClickListener {
            if (lock.getTag() != "open") {
                lock.setImageResource(R.drawable.round_lock_open_black_48)
                lock.setTag("open")
            }
            else {
                lock.setImageResource(R.drawable.round_lock_black_48)
                lock.setTag("closed")
            }
        }
    }
}