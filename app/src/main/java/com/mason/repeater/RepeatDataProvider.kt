package com.mason.repeater

import com.mason.repeater.model.RepeatData

class RepeatDataProvider private constructor() {
    val repeatDataList = ArrayList<RepeatData>()

    init {
//        repeatDataList.addAll(DummyData.getRepeatList())
    }

    companion object {
        val INSTANCE by lazy { RepeatDataProvider() }
    }

    fun addRepeatData(data: RepeatData) {
        repeatDataList.add(data)
    }
}