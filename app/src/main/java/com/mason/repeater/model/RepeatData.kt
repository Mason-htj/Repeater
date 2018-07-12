package com.mason.repeater.model

data class RepeatData(
        val id: Long? = null,
        var title: String = "",
        var detail: String = "",
        var startTime: Long = 0,
        var interval: Long = 0,
        var isActivate: Boolean = false
)