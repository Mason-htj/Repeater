package com.mason.repeater.ui

import android.arch.lifecycle.MutableLiveData
import com.mason.repeater.DummyData
import com.mason.repeater.RepeatDataManager
import com.mason.repeater.model.RepeatData

class MainViewModel private constructor() {
    val viewState = MutableLiveData<MainViewState>()
    val repeatList = MutableLiveData<List<RepeatData>>()
    private val repeatListCache = ArrayList<RepeatData>()

    init {
        viewState.value = MainViewState.NONE
        repeatListCache.addAll(RepeatDataManager.INSTANCE.repeatDataList)
        notifyRepeatListUpdate()
    }

    companion object {
        val INSTANCE by lazy { MainViewModel() }
    }

    fun addRepeatData(data: RepeatData) {
        RepeatDataManager.INSTANCE.addRepeatData(data)
        val success = repeatListCache.add(data)
        if (success) {
            notifyRepeatListUpdate()
        }
    }

    private fun notifyRepeatListUpdate() {
        repeatList.value = repeatListCache
    }
}