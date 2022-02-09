package com.example.newbasicstructure.viewmodel

import android.util.Log
import com.example.newbasicstructure.core.uI.BaseViewModel
import com.example.newbasicstructure.network.ApiException
import com.example.newbasicstructure.repository.DemoRepository
import com.example.newbasicstructure.util.extensionFunction.convertIntoErrorObjet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by JeeteshSurana.
 */

@HiltViewModel
class DemoViewModel @Inject constructor(
    private val repository: DemoRepository/*,
    private val context: Application*/
) : BaseViewModel() {

    suspend fun getData() = withContext(Dispatchers.Main) {
        try {
            val data = repository.getWeather()
            Log.e("TAG", "getData() data--> $data")
        } catch (e: ApiException) {
            mError.postValue(convertIntoErrorObjet(e))
        }
    }
}