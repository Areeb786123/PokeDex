package com.areeb.pokedeex.ui.base.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.areeb.pokedeex.data.Resource


open class BaseViewModel : ViewModel() {

    companion object {
        private val TAG = "BaseViewModel"
    }

    private val _resourceStatus = MutableLiveData<Resource<Any>?>()
    private val resourceStatus: LiveData<Resource<Any>?>
        get() = _resourceStatus

    fun setResourceStatus(resourceStatus: Resource<Any>?) {
        _resourceStatus.value = resourceStatus
    }

    fun clearResourceStatus() {
        _resourceStatus.value = null
    }

    fun setResourceError(error: String) {
        _resourceStatus.value = Resource.Error(
            false,
            null,
            null,
            error
        )
    }
}
