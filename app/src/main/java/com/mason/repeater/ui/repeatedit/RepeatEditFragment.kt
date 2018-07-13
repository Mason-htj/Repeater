package com.mason.repeater.ui.repeatedit

import android.content.Context
import android.os.Bundle
import com.mason.repeater.BaseFragment
import com.mason.repeater.R
import com.mason.repeater.model.RepeatData
import com.mason.repeater.ui.MainViewModel
import com.mason.repeater.ui.MainViewState
import kotlinx.android.synthetic.main.fragment_repeat_edit.*

class RepeatEditFragment : BaseFragment() {
    lateinit var listener: OnCompleteRepeatEditListener
    lateinit var repeatData: RepeatData
    private var isEditing = false

    companion object {
        private const val ARGUMENT_REPEAT_DATA = "ARGUMENT_REPEAT_DATA"
        fun newInstance(data: RepeatData?): RepeatEditFragment =
                RepeatEditFragment().apply {
                    val args = Bundle()
                    args.putParcelable(ARGUMENT_REPEAT_DATA, data)
                    arguments = args
                }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnCompleteRepeatEditListener) {
            listener = context
        } else {
            throw Exception("$context must implement OnRepeatAddListener")
        }
    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_repeat_edit

    override fun initView() {
        val temp = arguments?.getParcelable<RepeatData>(ARGUMENT_REPEAT_DATA)
        isEditing = temp != null
        repeatData = temp ?: RepeatData()

        editTitle.setText(repeatData.title)
        editDetail.setText(repeatData.detail)
        textAdd.text = if (isEditing) "Edit" else "Add"
        buttonAdd.setOnClickListener {
            saveRepeatData()
            if (isEditing) {
                listener.onCompleteRepeatEdit(repeatData)
            } else {
                listener.onCompleteRepeatAdd(repeatData)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        MainViewModel.INSTANCE.viewState.value = MainViewState.ADD
    }

    private fun saveRepeatData() {
        repeatData.title = editTitle.text.toString()
        repeatData.detail = editDetail.text.toString()
    }

    interface OnCompleteRepeatEditListener {
        fun onCompleteRepeatAdd(data: RepeatData)
        fun onCompleteRepeatEdit(data: RepeatData)
    }
}