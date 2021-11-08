package com.mindorks.kotlinlecture4.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindorks.kotlinlecture4.R
import com.mindorks.kotlinlecture4.model.Student
import com.mindorks.kotlinlecture4.services.NetworkService

class MainActivity : AppCompatActivity() {


    private lateinit var studentRecyclerView: androidx.recyclerview.widget.RecyclerView
    private lateinit var studentListAdapter: StudentListAdapter

    private lateinit var getTopperStudentButton: Button
    private lateinit var getStudentList: Button
    private lateinit var showStudentGrade: Button

    private lateinit var topperStudentName: TextView

    private lateinit var mainViewModel: MainViewModel

    private var topperStudent: Student? = null

    val clickListener: (Student) -> Unit = { student ->
        Toast.makeText(this, student.userName, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setupRecyclerView()
    }

    private fun init() {

        mainViewModel = MainViewModel(NetworkService())

        topperStudentName = findViewById(R.id.topperStudentName)

        getTopperStudentButton = findViewById(R.id.buttonGetTopper)




        getTopperStudentButton.setOnClickListener { view ->
            topperStudent = mainViewModel.getTopperStudent(this@MainActivity)
            topperStudentName.text = topperStudent?.userName ?: "Unknown"
        }

        getStudentList = findViewById(R.id.buttonGetStudentList)
        getStudentList.setOnClickListener { view ->
            val listStudent = mainViewModel.getListOfStudent(this@MainActivity)
            studentListAdapter.updateList(listStudent)
        }
        getStudentList.setOnClickListener { view ->
            val studentList = mainViewModel.getListOfStudent(this@MainActivity)
            studentListAdapter.updateList(studentList)
        }

        showStudentGrade = findViewById(R.id.buttonShowGrade)
        showStudentGrade.setOnClickListener {
            topperStudent?.let {
                val studentGrade = mainViewModel.getStudentGrade(it.averageMark)
                Toast.makeText(this@MainActivity, studentGrade, Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun setupRecyclerView() {

        studentRecyclerView = findViewById(R.id.studentList)

        studentListAdapter = StudentListAdapter(clickListener)

        studentRecyclerView.adapter = studentListAdapter

        studentRecyclerView.layoutManager = LinearLayoutManager(this)

    }

}
