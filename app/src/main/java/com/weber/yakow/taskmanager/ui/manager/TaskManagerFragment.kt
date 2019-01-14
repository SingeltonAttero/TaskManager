package com.weber.yakow.taskmanager.ui.manager

import com.weber.yakow.taskmanager.R
import com.weber.yakow.taskmanager.ui.global.BaseFragment

/**
 * Created on 15.01.19
 * @author YWeber
 * project TaskManager */

class TaskManagerFragment : BaseFragment() {

    companion object {
        fun newInstance(): TaskManagerFragment = TaskManagerFragment()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_task_manager
}