package com.mason.repeater

import android.app.Application

class RepeaterApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AlarmHelper.INSTANCE.initAlarmManager(this)
    }
}