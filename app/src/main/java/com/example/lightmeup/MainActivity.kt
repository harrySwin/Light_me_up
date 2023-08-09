package com.example.lightmeup

import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var lockState = "closed"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val key : ImageButton = findViewById<ImageButton>(R.id.key_btn)
        val lock : ImageView = findViewById<ImageView>(R.id.lock)

        checkKey(lockState, lock)

        if (savedInstanceState != null) {
            lockState = savedInstanceState.getString("LOCKSTATE").toString()
            checkKey(lockState, lock)
        }

        key.setOnClickListener {
            changeLock(lock)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("LOCKSTATE",lockState)
    }
    fun checkKey(lockState: String, lock: ImageView) {
        if (lockState == "open") {
            lock.setImageResource(R.drawable.round_lock_open_black_48)
        }
        else {
            lock.setImageResource(R.drawable.round_lock_black_48)
        }
    }
    fun changeLock(lock: ImageView) {
        if (lockState != "open") {
            lock.setImageResource(R.drawable.round_lock_open_black_48)
            this.lockState = ("open")
        }
        else {
            lock.setImageResource(R.drawable.round_lock_black_48)
            this.lockState = ("closed")
        }
    }
}
