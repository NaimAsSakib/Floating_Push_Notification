package com.example.floatingpushnotification

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    private lateinit var txt:TextView

    @SuppressLint("MissingInflatedId", "MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt=findViewById(R.id.qwe)

        /*tvPlay.setOnClickListener {
            var mediaPlayer= MediaPlayer.create(this,R.raw.short_sms_tone)
            mediaPlayer.start()
        }*/

       /* txt.setOnClickListener {
            //sendInstantPushNotification()

        }*/

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->


            // Get new FCM registration token
            val token = task.result

            // Log and toast
            txt.text= token
            Log.e("nsbcmbsmcnxmcb", token)
        }
        txt.setOnClickListener {
            copyToClipboard(txt.text.toString())
            Toast.makeText(this,"Copied", Toast.LENGTH_LONG).show()
            Log.e("listen", "listener clicked")
        }
    }

    /*@SuppressLint("MissingPermission")
    private fun sendInstantPushNotification(){
        val builder = NotificationCompat.Builder(this, "channel_id")
            .setSmallIcon(R.drawable.ic_tiger)
            .setContentTitle("Notification Title")
            .setContentText("Notification text")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(1,builder.build())

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("channel_id", "channel_name", NotificationManager.IMPORTANCE_DEFAULT)
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
    }*/


    fun Context.copyToClipboard(text: CharSequence){
        val clipboard = ContextCompat.getSystemService(this, ClipboardManager::class.java)
        clipboard?.setPrimaryClip(ClipData.newPlainText("",text))
    }

}