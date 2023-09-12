package com.example.lovecolculater.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.lovecolculater.R
import com.example.lovecolculater.databinding.ItemOnboardingBinding
import com.example.lovecolculater.model.onBoarding
import dagger.hilt.android.AndroidEntryPoint


class Adapter(private val onClick: () -> Unit) : RecyclerView.Adapter<Adapter.onBoardingHolder>() {

    private val data = arrayListOf(
        onBoarding(
            "Art of Love",
            "YWelcome to Love Calculate - your faithful companion in the world of romance and relationships!",
            R.raw.animation_lmghm7tc
        ),
        onBoarding(
            "Have a good time",
            "You should take the time to help those who need you",
            R.raw.animation_lmghnnfb
        ),
        onBoarding(
            "Cherishing love",
            "It is now no longer possible for you to cherish love",
            R.raw.animation_lmgho5wj
        ),
        onBoarding(
            "Have a breakup?",
            "We have made the correction for you don't worry\nMaybe someone is waiting for you!",
            R.raw.animation_lmghoeto
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardingHolder {
        return onBoardingHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: onBoardingHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class onBoardingHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoarding: onBoarding) {
            with(binding) {
                tvTitle.text = onBoarding.title
                tvDesc.text = onBoarding.text
                onBoarding.image.let { animationView.setAnimation(it) }
                btnNext.isVisible = adapterPosition == data.lastIndex

                btnNext.setOnClickListener {
                    onClick()
                }
            }

        }
    }
}