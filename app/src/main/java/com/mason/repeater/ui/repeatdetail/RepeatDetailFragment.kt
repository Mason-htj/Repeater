package com.mason.repeater.ui.repeatdetail

import com.mason.repeater.BaseFragment
import com.mason.repeater.R
import com.mason.repeater.RepeatDataProvider
import com.mason.repeater.model.RepeatData

class RepeatDetailFragment : BaseFragment() {
    companion object {
        fun newInstance(): RepeatDetailFragment = RepeatDetailFragment()
    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_repeat_detail

    override fun initView() {
        RepeatDataProvider.INSTANCE.addRepeatData(RepeatData(0L, "New Repeat", "New Repeat Detail", System.currentTimeMillis(), 1000L, true))
    }
}