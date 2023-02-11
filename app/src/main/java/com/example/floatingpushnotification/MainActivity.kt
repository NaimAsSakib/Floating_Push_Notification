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

    @SuppressLint("MissingInflatedId", "MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val txt =findViewById<TextView>(R.id.qwe)
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->


            // Get new FCM registration token
            val token = task.result

            // Log and toast
            txt.text= token
            //Log.d("nsbcmbsmcnxmcb", token)
        }
        txt.setOnClickListener {
            copyToClipboard(txt.text.toString())
            Toast.makeText(this,"Copied",Toast.LENGTH_LONG).show()
        }
    }
}

fun Context.copyToClipboard(text: CharSequence){
    val clipboard = ContextCompat.getSystemService(this, ClipboardManager::class.java)
    clipboard?.setPrimaryClip(ClipData.newPlainText("",text))
}





