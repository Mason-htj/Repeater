package com.mason.repeater

import com.mason.repeater.util.ConvertUtils
import org.junit.Assert
import org.junit.Test

class IntervalTextTest {
    @Test
    fun intervalTest() {
        val second = 1000L
        val minute = 60 * second
        val hour = 60 * minute
        val day = 24 * hour
        val week = 7 * day
        val month = 30 * day

        (1 until 59).forEach {
            Assert.assertTrue("${it}초에 한번" == ConvertUtils.getIntervalText(it * second))
        }
        (1 until 59).forEach {
            Assert.assertTrue("${it}분에 한번" == ConvertUtils.getIntervalText(it * minute))
        }
        (1 until 23).forEach {
            Assert.assertTrue("${it}시간에 한번" == ConvertUtils.getIntervalText(it * hour))
        }
        (1 until 6).forEach {
            Assert.assertTrue("${it}일에 한번" == ConvertUtils.getIntervalText(it * day))
        }
        (1 until 4).forEach {
            Assert.assertTrue("${it}주에 한번" == ConvertUtils.getIntervalText(it * week))
        }
        (1 until 5).forEach {
            Assert.assertTrue("${it}개월에 한번" == ConvertUtils.getIntervalText(it * month))
        }

        (1 until 59).forEach {
            Assert.assertTrue("${it}초에 한번" == ConvertUtils.getIntervalText(it * second + 500))
        }
        (1 until 59).forEach {
            Assert.assertTrue("${it}분에 한번" == ConvertUtils.getIntervalText(it * minute + 500))
        }
        (1 until 23).forEach {
            Assert.assertTrue("${it}시간에 한번" == ConvertUtils.getIntervalText(it * hour + 500))
        }
        (1 until 6).forEach {
            Assert.assertTrue("${it}일에 한번" == ConvertUtils.getIntervalText(it * day + 500))
        }
        (1 until 4).forEach {
            Assert.assertTrue("${it}주에 한번" == ConvertUtils.getIntervalText(it * week + 500))
        }
        (1 until 5).forEach {
            Assert.assertTrue("${it}개월에 한번" == ConvertUtils.getIntervalText(it * month + 500))
        }
    }
}