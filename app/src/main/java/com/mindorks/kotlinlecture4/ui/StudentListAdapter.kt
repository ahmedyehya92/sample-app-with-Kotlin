package com.mindorks.kotlinlecture4.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.mindorks.kotlinlecture4.R
import com.mindorks.kotlinlecture4.model.Student
import com.mindorks.kotlinlecture4.ui.StudentListAdapter.StudentViewHolder

class StudentListAdapter(
    private val onRecyclerViewItemClickListener: OnRecyclerViewItemClickListener
) : Adapter<StudentViewHolder>() {

    private var studentList: List<Student>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StudentViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_student_view, parent, false),
        onRecyclerViewItemClickListener
    )

    override fun getItemCount() = studentList?.size ?: 0

    override fun onBindViewHolder(viewholder: StudentViewHolder, position: Int) {

        val list = studentList
        if (list != null) {
            viewholder.bind(list[position])
        }
    }

    fun updateList(listStudent: List<Student>) {
        studentList = listStudent
        notifyDataSetChanged()
    }

    class StudentViewHolder(itemView: View, val onRecyclerViewItemClickListener: OnRecyclerViewItemClickListener) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        fun bind(student: Student) {

            val textView = itemView.findViewById<TextView>(R.id.studentName)

            textView.text = student.userName

            textView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    onRecyclerViewItemClickListener.onItemClick(student)
                }

            })
        }
    }
}