package com.slimshady.weather.base

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

abstract class BaseActivity<T : ViewModel> : AppCompatActivity() {

    private var viewModel: T? = null

    /**
     *
     * @return view model instance
     */
    abstract fun getViewModel(): T

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = if (viewModel == null) getViewModel() else viewModel
    }

}