package com.mason.repeater

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.mason.repeater.model.RepeatData
import com.mason.repeater.ui.MainActivity

class AlarmHelper private constructor() {
    private var isInit = false
    private lateinit var context: Context
    private lateinit var alarmManager: AlarmManager

    companion object {
        val INSTANCE by lazy { AlarmHelper() }
    }

    fun initAlarmManager(context: Context) {
        this.context = context
        this.alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        isInit = true
    }

    fun setAlarm(data: RepeatData) {
        throwIfNotInit()

        val type = AlarmManager.RTC_WAKEUP
        val intent = getAlarmIntent(data)
        val operation = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        alarmManager.set(type, data.alarmTime, operation)
    }

    private fun getAlarmIntent(data: RepeatData): Intent {
        val intent = Intent(context, MainActivity::class.java)
        intent.putExtra(StringKey.FROM, StringKey.FROM_ALARM)
        intent.putExtra(StringKey.DATA, data)
        return intent
    }

    private fun throwIfNotInit() {
        if (!isInit) {
            throw Exception("AlarmHelper must call initAlarmManager first.")
        }
    }
}