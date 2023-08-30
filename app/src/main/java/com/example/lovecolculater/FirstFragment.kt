package com.example.lovecolculater

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecolculater.databinding.FragmentFirstBinding
import com.example.lovecolculater.model.Love
import com.example.lovecolculater.presenter.FirstPresenter
import com.example.lovecolculater.view.FirstView

class FirstFragment : Fragment(),FirstView.View {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var presenter: FirstView.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        presenter = FirstPresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
        binding.history.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }

    }


   override fun initClicker() {
        binding.btnCalculate.setOnClickListener {
            presenter.calculateMatching(
                binding.etYou.text.toString(),
                binding.etMe.text.toString()
            )
        }

    }
    override  fun showResult(loveModel: Love?) {
      App.appDataBase.loveDao().insert(loveModel)
        findNavController().navigate(R.id.resultFragment, bundleOf("love" to loveModel))

    }

   override fun showError(message: String) {
        Log.e("ololo", "Error:$message")
    }
}
