package com.rsmartin.oompaloompa.presentation.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rsmartin.domain.error.ErrorEntity

open class BaseViewModel : ViewModel() {

    private val loadingLiveData = MutableLiveData<Boolean>()
    fun getLoadingObservable(): LiveData<Boolean> = loadingLiveData

    private val errorLiveData = MutableLiveData<ErrorEntity>()
    fun getErrorObservable(): LiveData<ErrorEntity> = errorLiveData

    protected fun showLoading(mustShow: Boolean) {
        loadingLiveData.postValue(mustShow)
    }

    protected fun showError(error: ErrorEntity) {
        showLoading(false)
        errorLiveData.postValue(error)
    }

    fun showGeneralError() {
        errorLiveData.postValue(ErrorEntity.Unknown)
    }

}