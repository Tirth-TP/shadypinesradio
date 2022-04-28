package com.shadypines.radio.core.uI

import androidx.lifecycle.ViewModel
import com.shadypines.radio.data.remote.model.ErrorModel
import com.shadypines.radio.util.bindingAdapter.mutableLiveData

/**
 * Created by JeeteshSurana.
 */

open class BaseViewModel : ViewModel() {
    var mError = mutableLiveData(ErrorModel())
}