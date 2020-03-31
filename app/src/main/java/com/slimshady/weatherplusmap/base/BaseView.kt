package com.slimshady.weatherplusmap.base

interface BaseView {

    fun cancelableLoading(message: String, fn: () -> Unit)
    fun dismissLoading()
    fun showNoConnection()

}