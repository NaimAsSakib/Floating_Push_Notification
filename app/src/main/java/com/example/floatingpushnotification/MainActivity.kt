package com.example.floatingpushnotification

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvPlay:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvPlay=findViewById(R.id.tvTV1)

        tvPlay.setOnClickListener {
            var mediaPlayer= MediaPlayer.create(this,R.raw.short_sms_tone)
            mediaPlayer.start()
        }

    }
}