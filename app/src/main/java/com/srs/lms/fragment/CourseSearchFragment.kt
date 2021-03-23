package com.srs.lms.fragment

import android.app.Activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.srs.lms.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CourseSearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CourseSearchFragment : Fragment() {
    val REQUEST_CODE = 11 // Used to identify the result


    lateinit var btnCourseSearch: Button
    lateinit var txtStartDate: EditText
    lateinit var txtEndDate:EditText
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
       val  view= inflater.inflate(R.layout.fragment_course_search, container, false)
        btnCourseSearch=view.findViewById(R.id.btn_Search)
        txtStartDate=view.findViewById(R.id.txtStartDate)
        txtEndDate=view.findViewById(R.id.txtEndDate)
        btnCourseSearch.setOnClickListener(){

            getFragmentManager()?.beginTransaction()
                ?.replace(R.id.frameLayout, CourseSearchResultFragment())
                ?.addToBackStack("Course Search")
                ?.commit()


           }

        txtStartDate.setOnClickListener(View.OnClickListener { // create the datePickerFragment
            txtStartDate.showSoftInputOnFocus=false

            val newFragment: DatePickerFragment = DatePickerFragment("StartDate")
            // set the targetFragment to receive the results, specifying the request code
            newFragment.setTargetFragment(this@CourseSearchFragment, REQUEST_CODE)
            // show the datePicker
            val fm: FragmentManager = (activity as AppCompatActivity?)!!.supportFragmentManager

            newFragment.show(fm, "datePicker")
        })

        txtEndDate.setOnClickListener(View.OnClickListener { // create the datePickerFragment
            txtEndDate.showSoftInputOnFocus=false

            val newFragment: DatePickerFragment = DatePickerFragment("EndDate")
            // set the targetFragment to receive the results, specifying the request code
            newFragment.setTargetFragment(this@CourseSearchFragment, REQUEST_CODE)
            // show the datePicker
            val fm: FragmentManager = (activity as AppCompatActivity?)!!.supportFragmentManager

            newFragment.show(fm, "datePicker")
        })
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // check for the results
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // get date from string
            var fieldName = data?.getStringExtra("key")
            var selectedDate =data?.getStringExtra("value")
            if(fieldName=="StartDate")
                 txtStartDate.setText(selectedDate)
            if(fieldName=="EndDate")
                txtEndDate.setText(selectedDate)
        }
    }

}