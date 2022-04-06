package com.slimshady.weather.base

import com.slimshady.weather.util.domain.Status


open class BaseViewState(private val baseStatus: Status, private val baseError: String?) {
    fun isLoading() = baseStatus == Status.LOADING
    fun getErrorMessage() = baseError
    fun shouldShowErrorMessage() = baseError != null
}
