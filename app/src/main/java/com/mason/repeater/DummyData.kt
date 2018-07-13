package com.mason.repeater

import com.mason.repeater.model.RepeatData
import java.util.*

object DummyData {
    private val DUMMY_SIZE = 100
    private val rand = Random()

    fun getRepeatList(): List<RepeatData> {
        val list = ArrayList<RepeatData>()

        (0..DUMMY_SIZE).forEach {
            list.add(RepeatData(it + 1L, "Repeat $it", "Detail $it", System.currentTimeMillis(), rand.nextInt(10000) * 60000L, true))
        }
        return list
    }
}