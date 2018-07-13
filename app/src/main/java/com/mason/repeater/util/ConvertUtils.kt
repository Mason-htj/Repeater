package com.mason.repeater.util

import com.mason.repeater.model.DayOfWeek
import com.mason.repeater.model.IntervalType

class ConvertUtils {
    companion object {
        fun getIntervalText(type: IntervalType, data: Int): String {
            when(type) {
                IntervalType.SECOND -> {
                    return "매 ${data}초"
                }
                IntervalType.MINUTE -> {
                    return "매 ${data}분"
                }
                IntervalType.HOUR -> {
                    return "매 ${data}시"
                }
                IntervalType.DAY -> {
                    return "매월 ${data}일"
                }
                IntervalType.MONTH -> {
                    return "매년 ${data}월"
                }
                IntervalType.WEEK -> {
                    return "매주 ${DayOfWeek.values()[data]}요일"
                }
            }
        }
    }
}