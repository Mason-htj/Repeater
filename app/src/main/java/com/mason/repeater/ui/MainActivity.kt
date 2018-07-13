package com.mason.repeater.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.mason.repeater.R
import com.mason.repeater.model.RepeatData
import com.mason.repeater.ui.repeatedit.RepeatEditFragment
import com.mason.repeater.ui.repeatdetail.RepeatDetailFragment
import com.mason.repeater.ui.repeatlist.RepeatListAdapter
import com.mason.repeater.ui.repeatlist.RepeatListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RepeatListAdapter.OnClickRepeatDataListener, RepeatEditFragment.OnCompleteRepeatEditListener, RepeatDetailFragment.OnEditRepeatDataListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        supportFragmentManager.beginTransaction()
                .add(R.id.containerFragment, RepeatListFragment.newInstance())
                .commit()
    }

    private fun initView() {
        FAB.setOnClickListener { showRepeatAdd() }

        MainViewModel.INSTANCE.viewState.observe(this, Observer {
            if (it == MainViewState.LIST) {
                FAB.show()
            } else {
                FAB.hide()
            }
        })
    }

    private fun showRepeatAdd() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, RepeatEditFragment.newInstance(null))
                .addToBackStack(null)
                .commit()
    }

    private fun showRepeatDetail(data: RepeatData) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, RepeatDetailFragment.newInstance(data))
                .addToBackStack(null)
                .commit()
    }

    override fun onClickRepeatData(data: RepeatData) {
        showRepeatDetail(data)
    }

    override fun onChangedActivate(data: RepeatData) {
        Toast.makeText(this, "${data.title}를 ${if (data.isActivate) "활성화" else "비활성화"}하였습니다.", Toast.LENGTH_SHORT).show()
    }

    override fun onCompleteRepeatEdit(data: RepeatData) {
        clearFragmentBackStack()
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, RepeatListFragment.newInstance())
                .commit()
    }

    override fun onCompleteRepeatAdd(data: RepeatData) {
        MainViewModel.INSTANCE.addRepeatData(data)
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, RepeatListFragment.newInstance())
                .commit()
    }

    override fun onEditRepeatData(data: RepeatData) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, RepeatEditFragment.newInstance(data))
                .addToBackStack(null)
                .commit()
    }

    private fun clearFragmentBackStack() {
        (0..supportFragmentManager.backStackEntryCount).forEach {
            supportFragmentManager.popBackStack()
        }
    }
}
