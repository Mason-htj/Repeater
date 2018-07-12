package com.mason.repeater.ui.repeatdetail

import com.mason.repeater.BaseFragment
import com.mason.repeater.R

class RepeatDetailFragment : BaseFragment() {
    companion object {
        fun newInstance(): RepeatDetailFragment = RepeatDetailFragment()
    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_repeat_detail

    override fun initView() {
    }
}