package com.rsmartin.oompaloompa.presentation.oompaloompalist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rsmartin.domain.Resource
import com.rsmartin.domain.model.OompaLoompasModel
import com.rsmartin.domain.usecase.GetOompaLoompas
import com.rsmartin.oompaloompa.presentation.common.BaseViewModel
import kotlinx.coroutines.launch

class OompaLoompaListViewModel(
    private val getOopaLoompas: GetOompaLoompas
) : BaseViewModel() {

    private val oompaLoompasListLiveData = MutableLiveData<OompaLoompasModel>()
    fun getOompaLoompaListObservable(): LiveData<OompaLoompasModel> = oompaLoompasListLiveData

    fun getOompaLoompasList(pagination: Int = 0) {
        showLoading(true)
        viewModelScope.launch {
            when (val result = getOopaLoompas.getOompaLoompas(pagination)) {
                is Resource.Success -> {
                    result.data.let {
                        oompaLoompasListLiveData.postValue(it)
                        showLoading(false)
                    }
                }

                is Resource.Error -> {
                    showError(result.error)
                }
            }
        }
    }
}