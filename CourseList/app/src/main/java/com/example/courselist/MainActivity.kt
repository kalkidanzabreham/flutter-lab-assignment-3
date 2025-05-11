package com.example.courselist

import CourseListTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.courselist.model.Course
import com.example.courselist.screens.CourseListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseListScreen(courses  = sampleCourses)
                }
            }
        }
    }
}

// Sample data
val sampleCourses = listOf(
    Course(
        title = "Introduction to Computer Science",
        code = "CS101",
        creditHours = 3,
        description = "Fundamental concepts of computer science including algorithms, data structures, and programming.",
        prerequisites = listOf("MATH100")
    ),
    Course(
        title = "Data Structures",
        code = "CS201",
        creditHours = 4,
        description = "Study of fundamental data structures including arrays, linked lists, stacks, queues, trees, and graphs.",
        prerequisites = listOf("CS101")
    ),
    Course(
        title = "Algorithms",
        code = "CS301",
        creditHours = 4,
        description = "Design and analysis of algorithms with emphasis on efficiency and correctness.",
        prerequisites = listOf("CS201", "MATH200")
    ),
    Course(
        title = "Database Systems",
        code = "CS401",
        creditHours = 3,
        description = "Principles of database design, implementation, and management.",
        prerequisites = listOf("CS201")
    ),
    Course(
        title = "Operating Systems",
        code = "CS402",
        creditHours = 4,
        description = "Principles of operating system design and implementation.",
        prerequisites = listOf("CS301")
    )
)

