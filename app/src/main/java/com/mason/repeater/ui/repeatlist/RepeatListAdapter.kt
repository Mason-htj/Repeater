package com.mason.repeater.ui.repeatlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mason.repeater.model.RepeatData

class RepeatListAdapter(private val listener: OnClickRepeatDataListener) : RecyclerView.Adapter<RepeatListViewHolder>() {
    private val list = ArrayList<RepeatData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepeatListViewHolder =
            RepeatListViewHolder.create(LayoutInflater.from(parent.context), parent, listener)

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RepeatListViewHolder, position: Int) {
        holder.setRepeatData(list[position])
    }

    fun setList(newList: List<RepeatData>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    interface OnClickRepeatDataListener {
        fun onClickRepeatData(data: RepeatData)
        fun onChangedActivate(data: RepeatData)
    }
}