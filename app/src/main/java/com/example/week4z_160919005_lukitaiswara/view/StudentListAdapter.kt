package com.example.week4z_160919005_lukitaiswara.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.week4z_160919005_lukitaiswara.R
import com.example.week4z_160919005_lukitaiswara.databinding.StudentListItemBinding
import com.example.week4z_160919005_lukitaiswara.model.Student
import com.example.week4z_160919005_lukitaiswara.util.loadImage
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter (val studentList:ArrayList<Student>):RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>()
    , ButtonDetailClickListener{


    class StudentViewHolder(var view: StudentListItemBinding):RecyclerView.ViewHolder(view.root)

    fun updateStudentList(newStudentList:List<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.student_list_item, parent, false)
        val v = DataBindingUtil.inflate<StudentListItemBinding>(inflater, R.layout.student_list_item, parent, false)

        return StudentViewHolder(v)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        Log.d("showtag", studentList[position].toString())
        holder.view.student = studentList[position]
        holder.view.listener = this
        /*holder.view.textIDstundent.setText(studentList[position].id)
        holder.view.txtStudentName.setText(studentList[position].name)
        holder.view.imageView.loadImage(studentList[position].photoUrl.toString(),
            holder.view.progressBar)



        holder.view.buttonDetail.setOnClickListener {
            val pid     = studentList[position].id.toString()
            val pname   = studentList[position].name.toString()
            val pbod    = studentList[position].bod.toString()
            val pphone  = studentList[position].phone.toString()
            val photo  = studentList[position].photoUrl.toString()
            val action = StudentListFragmentDirections.actionStudentDetail(pid, pname, pbod, pphone,photo)
            Navigation.findNavController(it).navigate(action)
        }*/

    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onButtonDetailClick(v: View) {
        Log.d("showtag", v.tag.toString())

        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString(),"","","","")
        Navigation.findNavController(v).navigate(action)
    }
}


