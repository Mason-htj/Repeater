package com.mason.repeater.util

import android.content.Context
import com.mason.repeater.R
import com.mason.repeater.model.DayOfWeek
import com.mason.repeater.model.IntervalType

class ConvertUtils {
    companion object {
        fun getIntervalText(context: Context, type: IntervalType, data: Int): String {
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
                    val texts = context.resources.getStringArray(R.array.name_day_of_week)
                    return "매주 ${texts[data]}"
                }
            }
        }
    }
}