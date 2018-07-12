package com.mason.repeater.ui.repeatlist

import android.arch.lifecycle.MutableLiveData
import com.mason.repeater.DummyData
import com.mason.repeater.model.RepeatData

class RepeatListViewModel private constructor() {
    val repeatList = MutableLiveData<List<RepeatData>>()

    init {
        repeatList.value = DummyData.getRepeatList()
    }

    companion object {
        val INSTANCE by lazy { RepeatListViewModel() }
    }
}