package com.weber.yakow.taskmanager.ui.manager

import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.weber.yakow.taskmanager.R
import com.weber.yakow.taskmanager.entity.Task
import com.weber.yakow.taskmanager.extension.alsoPrintDebug
import com.weber.yakow.taskmanager.presenter.manager.TaskManagerPresenter
import com.weber.yakow.taskmanager.presenter.manager.TaskManagerView
import com.weber.yakow.taskmanager.toothpick.DI
import com.weber.yakow.taskmanager.ui.global.BaseFragment
import com.weber.yakow.taskmanager.ui.manager.adapter.TaskManagerAdapter
import kotlinx.android.synthetic.main.fragment_task_manager.*
import toothpick.Toothpick

/**
 * Created on 15.01.19
 * @author YWeber
 * project TaskManager */

class TaskManagerFragment : BaseFragment(), TaskManagerView {
    companion object {
        fun newInstance(): TaskManagerFragment = TaskManagerFragment()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_task_manager
    @InjectPresenter
    lateinit var presenter: TaskManagerPresenter

    @ProvidePresenter
    fun presenterProvider(): TaskManagerPresenter = Toothpick
        .openScope(DI.NAVIGATION_SCOPE)
        .getInstance(TaskManagerPresenter::class.java)

    override fun bindPerson(persons: List<Task>) {
        persons.alsoPrintDebug("TTTTTTTTTTTTTTT")
        taskRecyclerView.adapter = TaskManagerAdapter(persons)
        taskRecyclerView.layoutManager = LinearLayoutManager(activity)
    }
}