package com.mason.repeater.ui

import android.arch.lifecycle.MutableLiveData
import com.mason.repeater.DummyData
import com.mason.repeater.RepeatDataProvider
import com.mason.repeater.model.RepeatData

class MainViewModel private constructor() {
    val viewState = MutableLiveData<MainViewState>()
    val repeatList = MutableLiveData<List<RepeatData>>()

    init {
        viewState.value = MainViewState.NONE
//        repeatList.value = RepeatDataProvider.INSTANCE.repeatDataList
        repeatList.value = DummyData.getRepeatList()
    }

    companion object {
        val INSTANCE by lazy { MainViewModel() }
    }

    fun addRepeatData(data: RepeatData) {
        RepeatDataProvider.INSTANCE.addRepeatData(data)
        repeatList.value = RepeatDataProvider.INSTANCE.repeatDataList
    }
}