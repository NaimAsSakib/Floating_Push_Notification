package com.example.floatingpushnotification

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    private lateinit var tvPlay:TextView

    private val NOTIFICATION_ID = 1
    @SuppressLint("MissingInflatedId", "MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvPlay=findViewById(R.id.tvTV1)

        /*tvPlay.setOnClickListener {
            var mediaPlayer= MediaPlayer.create(this,R.raw.short_sms_tone)
            mediaPlayer.start()
        }*/

        tvPlay.setOnClickListener {
            sendInstantPushNotification()

        }
    }

    @SuppressLint("MissingPermission")
    private fun sendInstantPushNotification(){
        val builder = NotificationCompat.Builder(this, "channel_id")
            .setSmallIcon(R.drawable.ic_tiger)
            .setContentTitle("Notification Title")
            .setContentText("Notification text")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager = NotificationManagerCompat.from(this)
        // notificationManager.notify(1, builder.build())
        notificationManager.notify(1,builder.build())

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("channel_id", "channel_name", NotificationManager.IMPORTANCE_DEFAULT)
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
    }
}