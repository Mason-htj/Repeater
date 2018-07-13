package com.mason.repeater

import com.mason.repeater.model.IntervalType
import com.mason.repeater.model.RepeatData
import java.util.*

object DummyData {
    private val DUMMY_SIZE = 200
    private val rand = Random()

    fun getRepeatList(): List<RepeatData> {
        val list = ArrayList<RepeatData>()

        (0..DUMMY_SIZE).forEach {
            val intervalType = IntervalType.values()[rand.nextInt(IntervalType.values().size)]
            val intervalData = when (intervalType) {
                IntervalType.SECOND,
                IntervalType.MINUTE -> {
                    rand.nextInt(60)
                }
                IntervalType.HOUR -> {
                    rand.nextInt(24)
                }
                IntervalType.DAY -> {
                    rand.nextInt(30) + 1
                }
                IntervalType.WEEK -> {
                    rand.nextInt(7)
                }
                IntervalType.MONTH -> {
                    rand.nextInt(12) + 1
                }
            }
            list.add(RepeatData(it + 1L, "Repeat $it", "Detail $it", System.currentTimeMillis(), intervalData, intervalType, true))
        }
        return list
    }
}