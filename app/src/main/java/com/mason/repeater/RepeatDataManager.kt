package com.mason.repeater

import com.mason.repeater.model.RepeatData

class RepeatDataManager private constructor() {
    val repeatDataList = ArrayList<RepeatData>()

    companion object {
        val INSTANCE by lazy { RepeatDataManager() }
    }

    fun addRepeatData(data: RepeatData): Boolean {
        repeatDataList.add(data)
        AlarmHelper.INSTANCE.setAlarm(data)
        return true
    }
}