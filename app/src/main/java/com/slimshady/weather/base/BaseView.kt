package com.slimshady.weather.base

interface BaseView {

    fun cancelableLoading(message: String, fn: () -> Unit)
    fun dismissLoading()
    fun showNoConnection()

}