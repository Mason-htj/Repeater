package com.mason.repeater

import com.mason.repeater.model.RepeatData

object DummyData {
    private val DUMMY_SIZE = 25

    fun getRepeatList(): List<RepeatData> {
        val list = ArrayList<RepeatData>()

        (0..DUMMY_SIZE).forEach {
            list.add(RepeatData(it + 1L, "Repeat $it", "Detail $it", System.currentTimeMillis(), 1000L, true))
        }
        return list
    }
}