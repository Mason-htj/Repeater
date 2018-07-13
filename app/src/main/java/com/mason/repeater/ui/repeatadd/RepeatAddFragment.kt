package com.mason.repeater.ui.repeatadd

import android.content.Context
import com.mason.repeater.BaseFragment
import com.mason.repeater.R
import com.mason.repeater.model.RepeatData
import com.mason.repeater.ui.MainViewModel
import com.mason.repeater.ui.MainViewState
import kotlinx.android.synthetic.main.fragment_repeat_add.*

class RepeatAddFragment : BaseFragment() {
    lateinit var listener: OnRepeatAddListener


    companion object {
        fun newInstance(): RepeatAddFragment = RepeatAddFragment()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnRepeatAddListener) {
            listener = context
        } else {
            throw Exception("$context must implement OnRepeatAddListener")
        }
    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_repeat_add

    override fun initView() {
        buttonAdd.setOnClickListener {
            listener.onRepeatAdd(RepeatData(0L, editTitle.text.toString(), editDetail.text.toString(), System.currentTimeMillis(), 1000L, true))
        }
    }

    override fun onResume() {
        super.onResume()
        MainViewModel.INSTANCE.viewState.value = MainViewState.ADD
    }

    interface OnRepeatAddListener {
        fun onRepeatAdd(data: RepeatData)
    }
}