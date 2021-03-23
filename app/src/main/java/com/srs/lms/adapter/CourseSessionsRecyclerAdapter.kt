package com.srs.lms.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.srs.lms.R
import com.srs.lms.model.CourseSession

class CourseSessionsRecyclerAdapter(val context: Context, val itemList:ArrayList<CourseSession>) : RecyclerView.Adapter<CourseSessionsRecyclerAdapter.CourseSessionsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseSessionsViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycler_course_single_row,parent,false)
        return CourseSessionsViewHolder(view)
    }
    class CourseSessionsViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val txtCourseName: TextView =view.findViewById(R.id.txtCourseName)
        val txtCourseCategory: TextView =view.findViewById(R.id.txtCourseCategory)
        val txtCourseTimeLine: TextView =view.findViewById(R.id.txtCourseTimeLine)
        val txtCourseRemainingSeats: TextView =view.findViewById(R.id.txtCourseRemainingSeats)
        // val imgBookImage: ImageView =view.findViewById(R.id.imgBookImage)
        // val llContent: LinearLayout =view.findViewById(R.id.llContent)


    }

    override fun onBindViewHolder(holder: CourseSessionsViewHolder, position: Int) {
        val courseSessions: CourseSession =itemList[position]
        holder.txtCourseName.text=courseSessions.courseName
        holder.txtCourseCategory.text=courseSessions.courseCategory
        holder.txtCourseTimeLine.text="${courseSessions.courseStartDate.toString()} - ${courseSessions.courseEndDate.toString()}"
        holder.txtCourseRemainingSeats.text= courseSessions.remainingSeats.toString()
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