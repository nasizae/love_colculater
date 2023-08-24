package com.example.lovecolculater

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecolculater.databinding.FragmentFirstBinding
import com.example.lovecolculater.model.Love
import com.example.lovecolculater.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var bundle: Bundle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                RetrofitService().api.calculateMatching(
                    etYou.text.toString(),
                    etMe.text.toString()
                ).enqueue(object : Callback<Love> {

                    override fun onResponse(call: Call<Love>, response: Response<Love>) {
                        Log.e("ololo", "OnResponse: ${response.body()}")
                        findNavController().navigate(
                            R.id.resultFragment,
                            bundleOf("love" to response.body())
                        )
                    }

                    override fun onFailure(call: Call<Love>, t: Throwable) {
                        Log.e("ololo", "OnFailure: ${t.message}")
                    }

                })
            }

        }
    }
}
