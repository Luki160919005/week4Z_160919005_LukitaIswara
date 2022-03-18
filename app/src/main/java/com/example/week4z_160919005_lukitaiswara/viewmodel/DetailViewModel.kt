package com.example.week4z_160919005_lukitaiswara.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyLog.TAG
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.week4z_160919005_lukitaiswara.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailViewModel(application: Application): AndroidViewModel(application) {
    var studentLD = MutableLiveData<Student>()
    /*
    fun fetch(pid : String, pname : String, pbod : String, pphone : String, photo:String) {
        val student1 = Student(pid, pname, pbod, pphone,photo)
        studentLD.value = student1
    }*/
    val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun fetch(pid : String) {
        queue = Volley.newRequestQueue(getApplication())
        Log.d("showvoley id", pid)
        val url = "http://adv.jitusolution.com/student.php?id="+pid

        Log.d("showvoley url", pid)
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val sType = object : TypeToken<Student>() { }.type

                studentLD.value = Gson().fromJson<Student>(response, sType)
                Log.d("showvoley2", studentLD.toString())
            },
            {
                Log.d("showvoley2", it.toString())

            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)

        /*val student1 = Student(pid, pname, pbod, pphone,photo)
        studentLD.value = student1*/
    }
}
