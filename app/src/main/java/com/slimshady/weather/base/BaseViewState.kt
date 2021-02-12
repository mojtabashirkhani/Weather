package com.slimshady.weather.base

import com.slimshady.weather.util.domain.Status

/**
 * Created by Furkan on 9.03.2020
 */

open class BaseViewState(private val baseStatus: Status, private val baseError: String?) {
    fun isLoading() = baseStatus == Status.LOADING
    fun getErrorMessage() = baseError
    fun shouldShowErrorMessage() = baseError != null
}
