package com.srs.lms.adapter


import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.srs.lms.R
import com.srs.lms.model.CourseSession
import com.srs.lms.model.EnrolledCourseSession

class EnrolledCourseSessionsRecyclerAdapter(val context: Context, val itemList:ArrayList<EnrolledCourseSession>) :
    RecyclerView.Adapter<EnrolledCourseSessionsRecyclerAdapter.EnrolledCourseSessionsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnrolledCourseSessionsViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycler_enrolledcourse_single_row,parent,false)
        return EnrolledCourseSessionsViewHolder(view)
    }

    class EnrolledCourseSessionsViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val txtCourseName: TextView =view.findViewById(R.id.txtCourseName)
        val txtCourseCategory: TextView =view.findViewById(R.id.txtCourseCategory)
        val txtCourseTimeLine: TextView =view.findViewById(R.id.txtCourseTimeLine)
        val txtCourseCredits: TextView =view.findViewById(R.id.txtCourseCredits)
        // val imgBookImage: ImageView =view.findViewById(R.id.imgBookImage)
        // val llContent: LinearLayout =view.findViewById(R.id.llContent)


    }
    fun getTotCredits():Int
    {
        var totCredits:Int=0
        for(course in itemList)
        {
            totCredits+=course.courseCredit
        }
        return totCredits
    }

    override fun onBindViewHolder(holder: EnrolledCourseSessionsViewHolder, position: Int) {
        val courseSessions: EnrolledCourseSession =itemList[position]
        holder.txtCourseName.text=courseSessions.courseName
        holder.txtCourseCategory.text=courseSessions.courseCategory

        holder.txtCourseTimeLine.text="${courseSessions.courseStartDate.toString()} - ${courseSessions.courseEndDate.toString()}"
        holder.txtCourseCredits.text=courseSessions.courseCredit.toString()

        // Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.imgBookImage)

        /* holder.llContent.setOnClickListener(){
             val intent= Intent(context,DescriptionActivity::class.java)
             intent.putExtra("book_id",book.bookId)
             context.startActivity(intent)

         }*/

    }



    override fun getItemCount(): Int {
        return itemList.size
    }
}