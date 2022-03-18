package com.example.week4z_160919005_lukitaiswara.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week4z_160919005_lukitaiswara.R
import com.example.week4z_160919005_lukitaiswara.model.Student
import com.example.week4z_160919005_lukitaiswara.util.loadImage
import com.example.week4z_160919005_lukitaiswara.util.loadImage2
import com.example.week4z_160919005_lukitaiswara.viewmodel.DetailViewModel
import com.example.week4z_160919005_lukitaiswara.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_list.*
import kotlinx.android.synthetic.main.student_list_item.*
import kotlinx.android.synthetic.main.student_list_item.view.*


class StudentDetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var pid = ""
        var pname = ""
        var pbod = ""
        var pphone = ""
        var photo = ""
        if(arguments != null) {
            pid     = StudentDetailFragmentArgs.fromBundle(requireArguments()).pid
            pname   = StudentDetailFragmentArgs.fromBundle(requireArguments()).pname
            pbod    = StudentDetailFragmentArgs.fromBundle(requireArguments()).pbod
            pphone  = StudentDetailFragmentArgs.fromBundle(requireArguments()).pphone
            photo  = StudentDetailFragmentArgs.fromBundle(requireArguments()).pphoto
        }

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(pid)
        observeViewModel()
    }

    fun observeViewModel() {
        Log.d("showvoley","masuk")
        Log.d("showvoley","masuk:"+viewModel.studentLD.value?.id)
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            Log.d("showvoley","id:"+it.id.toString())
            textID.setText(it.id.toString())
            txtName.setText(it.name.toString())
            txtBod.setText(it.bod.toString())
            txtPhone.setText(it.phone.toString())


            imageViewStudent.loadImage2(it.photoUrl.toString())
        })
    }


}