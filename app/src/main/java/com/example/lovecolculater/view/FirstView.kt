package com.example.lovecolculater.view

import com.example.lovecolculater.model.Love

interface FirstView {
    interface View {
        fun initClicker()
        fun showResult(loveModel: Love?)
        fun showError(message: String)
    }

    interface Presenter {
        fun calculateMatching(first: String, second: String)

    }
}