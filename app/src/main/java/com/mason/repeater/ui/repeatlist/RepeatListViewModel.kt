package com.mason.repeater.ui.repeatlist

import android.arch.lifecycle.MutableLiveData
import com.mason.repeater.DummyData
import com.mason.repeater.RepeatDataProvider
import com.mason.repeater.model.RepeatData

class RepeatListViewModel private constructor() {
    val repeatList = MutableLiveData<List<RepeatData>>()

    init {
        repeatList.value = RepeatDataProvider.INSTANCE.repeatDataList
    }

    companion object {
        val INSTANCE by lazy { RepeatListViewModel() }
    }

    fun addRepeatData(data: RepeatData) {
        RepeatDataProvider.INSTANCE.addRepeatData(data)
        repeatList.value = RepeatDataProvider.INSTANCE.repeatDataList
    }
}