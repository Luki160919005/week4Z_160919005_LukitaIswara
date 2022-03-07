package com.example.week4z_160919005_lukitaiswara.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week4z_160919005_lukitaiswara.model.Student

class DetailViewModel: ViewModel() {
    val studentLD = MutableLiveData<Student>()

    fun fetch(pid : String, pname : String, pbod : String, pphone : String) {
        val student1 = Student(pid, pname, pbod, pphone,"http://dummyimage.com/75x100.jpg/cc0000/ffffff")
        studentLD.value = student1
    }
}
