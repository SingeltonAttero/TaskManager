package com.weber.yakow.taskmanager.ui.manager.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weber.yakow.taskmanager.R
import com.weber.yakow.taskmanager.entity.Task
import kotlinx.android.synthetic.main.item_task_adapter.view.*

/**
 * Created on 16.01.19
 * @author YWeber
 * project TaskManager */

class TaskManagerAdapter(private val listTask: List<Task>) : RecyclerView.Adapter<TaskManagerAdapter.TaskViewHolder>() {
    override fun getItemCount(): Int = listTask.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(listTask[position])
    }

    override fun onCreateViewHolder(conteiner: ViewGroup, type: Int): TaskViewHolder {
        val view = LayoutInflater.from(conteiner.context).inflate(R.layout.item_task_adapter, conteiner, false)
        return TaskViewHolder(view)
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(task: Task) {
            itemView.nameView.text = task.name
            itemView.taskTextView.text = task.description
            itemView.dateView.text = task.date
        }
    }
}