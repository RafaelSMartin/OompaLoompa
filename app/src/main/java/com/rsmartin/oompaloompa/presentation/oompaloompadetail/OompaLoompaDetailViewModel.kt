package com.rsmartin.oompaloompa.presentation.oompaloompadetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rsmartin.domain.Resource
import com.rsmartin.domain.model.OompaLoompaItem
import com.rsmartin.domain.usecase.GetOompaLoompa
import com.rsmartin.oompaloompa.presentation.common.BaseViewModel
import kotlinx.coroutines.launch

class OompaLoompaDetailViewModel(
    private val getOompaLoompa: GetOompaLoompa,
) : BaseViewModel() {

    private val heroDetailLiveData = MutableLiveData<OompaLoompaItem?>()
    fun getHeroDetailObservable(): LiveData<OompaLoompaItem?> = heroDetailLiveData

    fun getOompaLoompaDetail(heroId: Int) {
        showLoading(true)
        viewModelScope.launch {
            when (val result = getOompaLoompa.getOompaLoompa(heroId)) {
                is Resource.Success -> {
                    result.data.let {
                        heroDetailLiveData.postValue(result.data)
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