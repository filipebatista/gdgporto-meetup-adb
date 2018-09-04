package com.filipebaptista.gdgportomeetup.receiver

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.widget.Toast
import com.filipebaptista.gdgportomeetup.MainActivity


/**
 * Created by FilipeBatista on 16/08/2018.
 */
class GDGPortoMeetUpReceiver : BroadcastReceiver() {
    companion object {
        const val ALARM_DELAY = 90_000L
        const val ACTION_HELLO = "com.filipebaptista.gdgportomeetup.ACTION_HELLO"
        const val ACTION_SET_ALARM = "com.filipebaptista.gdgportomeetup.ACTION_SET_ALARM"
        const val ACTION_HELLO_ALARM = "com.filipebaptista.gdgportomeetup.ACTION_HELLO_FROM_ALARM"
        const val ACTION_HELLO_WITH_EXTRA = "com.filipebaptista.gdgportomeetup.ACTION_HELLO_WITH_EXTRA"
        const val HELLO_EXTRA_NAME = "extra_name"
    }

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            ACTION_HELLO -> Toast.makeText(context, "Hello GDG Porto :)", Toast.LENGTH_LONG).show()
            ACTION_SET_ALARM -> setAlarm(context)
            ACTION_HELLO_ALARM -> Toast.makeText(context, "Hello GDG Porto from alarm :)", Toast.LENGTH_LONG).show()
            ACTION_HELLO_WITH_EXTRA -> {
                val name = intent.getStringExtra(HELLO_EXTRA_NAME)
                Toast.makeText(context, String.format("Hello %s", name), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setAlarm(context: Context) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmIntent = Intent(context, GDGPortoMeetUpReceiver::class.java).let { intent ->
            intent.action = ACTION_HELLO_ALARM
            //PendingIntent.getBroadcast(context, 0, intent, 0)
            PendingIntent.getActivity(context, 0, Intent(context, MainActivity::class.java), PendingIntent.FLAG_ONE_SHOT)

        }
        alarmManager.set(
                AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + ALARM_DELAY,
                alarmIntent
        )
    }
}