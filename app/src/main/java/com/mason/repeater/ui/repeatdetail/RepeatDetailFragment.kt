package com.mason.repeater.ui.repeatdetail

import android.content.Context
import android.os.Bundle
import com.mason.repeater.BaseFragment
import com.mason.repeater.R
import com.mason.repeater.model.RepeatData
import com.mason.repeater.ui.MainViewModel
import com.mason.repeater.ui.MainViewState
import kotlinx.android.synthetic.main.fragment_repeat_detail.*

class RepeatDetailFragment : BaseFragment() {
    lateinit var listener: OnEditRepeatDataListener
    lateinit var repeatData: RepeatData

    companion object {
        private const val ARGUMENT_REPEAT_DATA = "ARGUMENT_REPEAT_DATA"
        fun newInstance(data: RepeatData): RepeatDetailFragment {
            val args = Bundle()
            args.putParcelable(ARGUMENT_REPEAT_DATA, data)

            return RepeatDetailFragment().apply {
                arguments = args
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnEditRepeatDataListener) {
            listener = context
        } else {
            throw Exception("$context must implement OnEditRepeatDataListener")
        }
    }

    override fun onResume() {
        super.onResume()
        MainViewModel.INSTANCE.viewState.value = MainViewState.DETAIL
    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_repeat_detail

    override fun initView() {
        val temp = arguments?.getParcelable<RepeatData>(ARGUMENT_REPEAT_DATA)
        if (temp == null) {
            activity?.onBackPressed()
            return
        }

        repeatData = temp
        textTitle.text = repeatData.title
        textDetail.text = repeatData.detail

        buttonEdit.setOnClickListener { listener.onEditRepeatData(repeatData) }
    }

    interface OnEditRepeatDataListener {
        fun onEditRepeatData(data: RepeatData)
    }
}