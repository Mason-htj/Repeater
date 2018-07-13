package com.mason.repeater.util

class ConvertUtils {
    companion object {
        fun getIntervalText(interval: Long): String {
            val second = 1000L
            val minute = 60 * second
            val hour = 60 * minute
            val day = 24 * hour
            val week = 7 * day
            val month = 30 * day

            return when {
                interval < minute -> {
                    "${interval / second}초에 한번"
                }
                interval < hour -> {
                    "${interval / minute}분에 한번"
                }
                interval < day -> {
                    "${interval / hour}시간에 한번"
                }
                interval < week -> {
                    "${interval / day}일에 한번"
                }
                interval < month -> {
                    "${interval / week}주에 한번"
                }
                else -> {
                    "${interval / month}개월에 한번"
                }
            }
        }
    }
}