package com.shadypines.radio.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.shadypines.radio.R
import com.shadypines.radio.core.uI.BaseActivity
import com.shadypines.radio.viewmodel.DemoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val homeViewModel: DemoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            delay(2000)
            homeViewModel.getData()
        }
    }
}