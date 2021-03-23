package com.srs.lms.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.srs.lms.R
import com.srs.lms.adapter.CourseSessionsRecyclerAdapter
import com.srs.lms.adapter.EnrolledCourseSessionsRecyclerAdapter
import com.srs.lms.model.EnrolledCourseSession


class DashBoardFragment : Fragment() {
    lateinit var recyclerEnrolledCourseSessions: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var txtTotCredits: TextView
   // lateinit var progressBar: ProgressBar
   // lateinit var progressLayout: RelativeLayout
    lateinit var recyclerAdapter: EnrolledCourseSessionsRecyclerAdapter
    val enrolledCourseSessionsList = arrayListOf<EnrolledCourseSession>(
        EnrolledCourseSession(267,6,4,"Management of Information System",
            "Management",1,30,"2021-02-19","2021-03-21",
            1,"rani",12,"harini"),
        EnrolledCourseSession(384,8,18,"Organic Chemistry",
            "Chemistry",6,40,"2021-04-01","2021-05-10",
            11,"Hara  Patkar",12,"harini")

    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_dash_board, container, false)
        setHasOptionsMenu(true)
        recyclerEnrolledCourseSessions= view.findViewById(R.id.recyclerEnrolledCourseSessions)
        txtTotCredits=view.findViewById(R.id.txtTotCredits)
        // progressBar=view.findViewById(R.id.progressBar)
       // progressLayout=view.findViewById(R.id.progressLayout)
       // progressLayout.visibility=View.INVISIBLE
        layoutManager = LinearLayoutManager(activity)
        recyclerAdapter = EnrolledCourseSessionsRecyclerAdapter(activity as Context, enrolledCourseSessionsList)
        recyclerEnrolledCourseSessions.adapter = recyclerAdapter
        recyclerEnrolledCourseSessions.layoutManager = layoutManager
        val totCredits:Int=recyclerAdapter.getTotCredits()

        txtTotCredits.text=totCredits.toString()
        return view
    }


}