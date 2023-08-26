package com.example.lovecolculater.presenter

import com.example.lovecolculater.model.Love
import com.example.lovecolculater.service.RetrofitService
import com.example.lovecolculater.view.FirstView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstPresenter(private val view:FirstView.View):FirstView.Presenter {
    override fun calculateMatching(first: String, second: String) {
        RetrofitService().api.calculateMatching(first, second).enqueue(object :
            Callback<Love> {
            override fun onResponse(call: Call<Love>, response: Response<Love>) {
                view.showResult(response.body())
            }

            override fun onFailure(call: Call<Love>, t: Throwable) {
                view.showError(t.message ?: "Error")
            }
        })
    }
}