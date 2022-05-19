package com.example.week4z_160919005_lukitaiswara.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week4z_160919005_lukitaiswara.R
import com.example.week4z_160919005_lukitaiswara.databinding.StudentListItemBinding
import com.example.week4z_160919005_lukitaiswara.databinding.FragmentStudentDetailBinding
import com.example.week4z_160919005_lukitaiswara.model.Student
import com.example.week4z_160919005_lukitaiswara.model.StudentDetail
import com.example.week4z_160919005_lukitaiswara.util.loadImage
import com.example.week4z_160919005_lukitaiswara.util.loadImage2
import com.example.week4z_160919005_lukitaiswara.viewmodel.DetailViewModel
import com.example.week4z_160919005_lukitaiswara.viewmodel.ListViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_list.*
import kotlinx.android.synthetic.main.student_list_item.*
import kotlinx.android.synthetic.main.student_list_item.view.*
import kotlinx.coroutines.NonDisposableHandle.parent
import java.util.concurrent.TimeUnit


class StudentDetailFragment : Fragment(), ButtonCreateNotification {

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_student_detail, container, false)
        binding.listenerNotification = this
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var pid = ""
        if(arguments != null) {
            pid     = StudentDetailFragmentArgs.fromBundle(requireArguments()).pid
        }
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(pid)
        observeViewModel()
    }

    private lateinit var binding: FragmentStudentDetailBinding
    var studentName = "";
    fun observeViewModel() {


        Log.d("showvoley","masuk")
        Log.d("showvoley","masuk:"+viewModel.studentLD.value?.id)




        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            Log.d("showtag2",it.toString())

            val studentDetailData = Student(it.id.toString(), it.name.toString(),it.bod.toString(),it.phone.toString(),it.photoUrl.toString())



            binding.studentDetail = it

            studentName = it.name.toString()

            //onButtonCreateNotification(it.name.toString())
            /*
            viewModel.studentDetail = it
            holder.view.listener = this*/
            /*

            textID.setText(it.id.toString())
            txtName.setText(it.name.toString())
            txtBod.setText(it.bod.toString())
            txtPhone.setText(it.phone.toString())

            imageViewStudent.loadImage2(it.photoUrl.toString())

            var student = it


            btnNotif.setOnClickListener {
                Observable.timer(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        Log.d("Messages", "five seconds")
                        MainActivity.showNotification(student.name.toString(),
                            "A new notification created",
                            R.drawable.ic_baseline_person_24)
                    }
            }*/


        })
    }

    override fun onButtonCreateNotification(v: View) {
        Log.d("showcek", "create notif")
        Observable.timer(5, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("Messages", "five seconds")
                MainActivity.showNotification(studentName,
                    "A new notification created",
                    R.drawable.ic_baseline_person_24)
            }
    }


}