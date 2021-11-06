package com.mindorks.kotlinlecture4.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindorks.kotlinlecture4.R
import com.mindorks.kotlinlecture4.model.Student
import com.mindorks.kotlinlecture4.services.NetworkService

class MainActivity : AppCompatActivity(), OnRecyclerViewItemClickListener {


    private lateinit var studentRecyclerView: androidx.recyclerview.widget.RecyclerView
    private lateinit var studentListAdapter: StudentListAdapter

    private lateinit var getTopperStudentButton: Button
    private lateinit var getStudentList: Button
    private lateinit var showStudentGrade: Button

    private lateinit var topperStudentName: TextView

    private lateinit var mainViewModel: MainViewModel

    private var topperStudent: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setupRecyclerView()
    }

    override fun onItemClick(student: Student) {
        Toast.makeText(this, student.userName, Toast.LENGTH_SHORT).show()
    }

    private fun init() {

        mainViewModel = MainViewModel(NetworkService())

        topperStudentName = findViewById(R.id.topperStudentName)

        getTopperStudentButton = findViewById(R.id.buttonGetTopper)
        getTopperStudentButton.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                topperStudent = mainViewModel.getTopperStudent(this@MainActivity)
                topperStudentName.text = topperStudent?.userName ?: "Unknown"

            }

        })

        getStudentList = findViewById(R.id.buttonGetStudentList)
        getStudentList.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                val studentList = mainViewModel.getListOfStudent(this@MainActivity)
                studentListAdapter.updateList(studentList)
            }

        })

        showStudentGrade = findViewById(R.id.buttonShowGrade)
        showStudentGrade.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                topperStudent?.let {
                    val studentGrade = mainViewModel.getStudentGrade(it.averageMark)
                    Toast.makeText(this@MainActivity, studentGrade, Toast.LENGTH_SHORT).show()
                }

            }

        })

    }

    private fun setupRecyclerView() {

        studentRecyclerView = findViewById(R.id.studentList)

        studentListAdapter = StudentListAdapter(this)

        studentRecyclerView.adapter = studentListAdapter

        studentRecyclerView.layoutManager = LinearLayoutManager(this)

    }

}

interface OnRecyclerViewItemClickListener {
    fun onItemClick(student: Student)
}