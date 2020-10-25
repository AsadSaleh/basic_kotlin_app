package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getUsers();
    }

    private fun getUsers() {
        val call = RetrofitClientInstance.buildService(ApiService::class.java).getUsers();
        call.enqueue(object : Callback<List<UserResponse>> {
            override fun onResponse(call: Call<List<UserResponse>>?, response: Response<List<UserResponse>>?) {
                val userResponse = response?.body()!!
                listview.adapter = UserAdapter(userResponse);
            }

            override fun onFailure(call: Call<List<UserResponse>>?, t: Throwable?) {
            }

        })
    }
}