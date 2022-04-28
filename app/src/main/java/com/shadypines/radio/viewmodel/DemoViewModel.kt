package com.shadypines.radio.viewmodel

import com.shadypines.radio.core.uI.BaseViewModel
import com.shadypines.radio.network.ApiException
import com.shadypines.radio.repository.DemoRepository
import com.shadypines.radio.util.extensionFunction.convertIntoErrorObjet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by JeeteshSurana.
 */

@HiltViewModel
class DemoViewModel @Inject constructor(
    private val repository: DemoRepository
) : BaseViewModel() {

    suspend fun getData() = withContext(Dispatchers.Main) {
        try {
            repository.getWeather()
        } catch (e: ApiException) {
            mError.postValue(convertIntoErrorObjet(e))
        }
    }
}