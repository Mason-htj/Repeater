package com.mason.repeater.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mason.repeater.R
import com.mason.repeater.model.RepeatData
import com.mason.repeater.ui.repeatdetail.RepeatDetailFragment
import com.mason.repeater.ui.repeatlist.RepeatListAdapter
import com.mason.repeater.ui.repeatlist.RepeatListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RepeatListAdapter.OnClickRepeatDataListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        supportFragmentManager.beginTransaction()
                .add(R.id.containerFragment, RepeatListFragment.newInstance())
                .commit()
    }

    private fun initView() {
        FAB.setOnClickListener { showRepeatDetail(null) }
    }

    private fun showRepeatDetail(data: RepeatData?) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, RepeatDetailFragment.newInstance())
                .addToBackStack(null)
                .commit()
    }

    override fun onClickRepeatData(data: RepeatData) {
        showRepeatDetail(data)
    }
}
