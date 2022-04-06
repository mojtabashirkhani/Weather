package com.slimshady.weather.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView



open class BaseViewHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)
