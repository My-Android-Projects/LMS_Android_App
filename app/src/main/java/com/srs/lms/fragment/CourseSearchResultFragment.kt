package com.srs.lms.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.srs.lms.R
import com.srs.lms.adapter.CourseSessionsRecyclerAdapter
import com.srs.lms.model.CourseSession



class CourseSearchResultFragment : Fragment() {




    lateinit var recyclerCourseSessions: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var progressBar: ProgressBar
    lateinit var progressLayout: RelativeLayout
    lateinit var recyclerAdapter: CourseSessionsRecyclerAdapter
    val courseSessionsList = arrayListOf<CourseSession>(
        CourseSession(	5,	5,	"Deep Learning","Technology",	5,
            80,	"rani",	30,	0,	"2021-03-12",
            "2021-03-28"),
        CourseSession(	4,2,	"Web Development",	"Technology",	2,
        69,	"rani",	30,	11,	"2021-03-18",
        "2021-03-28"),
        CourseSession(	2,	1,	"Python basics",	"Technology",
        2,39,	"rani",	30,	7,	"2021-03-29",
        "2021-07-05"),
        CourseSession(	3,	3,	"Marketing Research",	"Management",
        4,	74,	"ravi",	30,	21,	"2020-12-02",
        "2021-04-27",	),
        CourseSession(	6,	4,	"Management of Information System",	"Management",
        1,	30,"rani",40,2,	"2021-02-19",
        "2021-03-21"),

        CourseSession(	7,	11,	"Acoustical Physics",	"Physics",
        3,	69,	"Girish  Ghose",	50,	0,
        "2021-03-19",	"2021-05-28"),
        CourseSession(	12,	10,	"Fluid Physics",	"Physics",
        8,	70,	"Sara  Mapkar",	20,	11,
        "2021-03-20",	"2021-04-18"),
        CourseSession(	15,	10,	"Fluid Physics",	"Physics",
        8,	70,	"Hara  Patkar",	12,	1,
        "2021-03-27",	"2021-04-23"),
        CourseSession(	13,	12,	"Astrophysics",	"Physics",
        2,	72,	"Sara  Mapkar",	20,	7,
        "2021-05-02","2021-07-16"),
        CourseSession(	14,	19,	"Physical Chemistry",	"Chemistry",
        2,	35,	"Girish  Ghose",30,	8,
        "2021-03-12",	"2021-05-07"),
        CourseSession(	10,	17,	"Inorganic Chemistry",	"Chemistry",
        4,	45,	"Mahesa  Kalla",	20,	12,
        "2021-03-27",	"2021-04-30"),
        CourseSession(	8,	18,	"Organic Chemistry",	"Chemistry",
        6,	40,	"Hara  Patkar",	30,	0,
        "2021-04-01",	"2021-05-10"	),

        CourseSession(	11,	9,	"Physical Chemistry",	"Chemistry",
        2,	35,	"Mahesa  Kalla",	10,	2,
        "2021-04-15",	"2021-05-21"),
        CourseSession(	9,	14,	"Coastal and Ocean Engineering",	"Civil",
        2,34,"Airavata  Padmanabhan",	20,	6,
        "2021-03-05",	"2021-04-09")

    )


    private var courseName:String?=null
    private var courseCategory:String?=null
    private var courseCredits:String?=null
    private var courseStartDate:String?=null
    private var courseEndDate:String?=null





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_course_search_result, container, false)
        courseName=arguments?.getString("courseName")
        courseCategory=arguments?.getString("courseCategory")
        courseCredits=arguments?.getString("courseCredits")
        courseStartDate=arguments?.getString("courseStartDate")
        courseEndDate=arguments?.getString("courseEndDate")

        println("CourseSearchResultFragment: $courseName")
        println("CourseSearchResultFragment: $courseCategory")
        println("CourseSearchResultFragment: $courseCredits")
        println("CourseSearchResultFragment: $courseStartDate")
        println("CourseSearchResultFragment: $courseEndDate")
        setHasOptionsMenu(true)
        recyclerCourseSessions= view.findViewById(R.id.recyclerCourseSessions)
        progressBar=view.findViewById(R.id.progressBar)
        progressLayout=view.findViewById(R.id.progressLayout)
        progressLayout.visibility=View.INVISIBLE
        layoutManager = LinearLayoutManager(activity)
        recyclerAdapter = CourseSessionsRecyclerAdapter(activity as Context, courseSessionsList)
        recyclerCourseSessions.adapter = recyclerAdapter
        recyclerCourseSessions.layoutManager = layoutManager
        return view
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment sample.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            CourseSearchResultFragment().apply {

            }
    }

}