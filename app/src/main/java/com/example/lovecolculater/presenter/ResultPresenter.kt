package com.example.lovecolculater.presenter

import android.os.Bundle
import com.example.lovecolculater.model.Love
import com.example.lovecolculater.view.ResultView

class ResultPresenter(private val view: ResultView.View):ResultView.Presenter {
    private lateinit var loveModel: Love
    override fun onViewCreated(argument: Bundle?) {
        loveModel = argument?.getSerializable("love") as Love
        view.displayLoveModel(loveModel)
    }

    override fun onTryButtonClick() {
        view.navigateToMainFragment()
    }
}