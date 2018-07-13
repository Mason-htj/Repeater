package com.mason.repeater.ui.repeatlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mason.repeater.R
import com.mason.repeater.model.RepeatData
import com.mason.repeater.util.ConvertUtils
import kotlinx.android.synthetic.main.viewholder_repeat_list.view.*

class RepeatListViewHolder(itemView: View,
                           private val listener: RepeatListAdapter.OnClickRepeatDataListener) : RecyclerView.ViewHolder(itemView) {
    private var data: RepeatData? = null

    init {
        itemView.setOnClickListener { data?.let { listener.onClickRepeatData(it) } }
    }

    companion object {
        fun create(inflater: LayoutInflater, parent: ViewGroup, listener: RepeatListAdapter.OnClickRepeatDataListener): RepeatListViewHolder =
                RepeatListViewHolder(inflater.inflate(R.layout.viewholder_repeat_list, parent, false), listener)
    }

    fun setRepeatData(data: RepeatData?) {
        this.data = data
        itemView.textTitle.text = data?.title
        itemView.textDetail.text = data?.detail
        itemView.textInterval.text = ConvertUtils.getIntervalText(data?.interval ?: 0)
        itemView.switchActivate.isChecked = data?.isActivate == true
    }
}