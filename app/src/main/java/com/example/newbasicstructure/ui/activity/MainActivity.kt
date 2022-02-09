package com.example.newbasicstructure.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.newbasicstructure.core.uI.BaseActivity
import com.example.newbasicstructure.databinding.ActivityMainBinding
import com.example.newbasicstructure.util.RequestCodeUtil
import com.example.newbasicstructure.util.extensionFunction.CheckPermission
import com.example.newbasicstructure.util.extensionFunction.cameraWithStoragePermission
import com.example.newbasicstructure.util.extensionFunction.checkPermission
import com.example.newbasicstructure.util.helper.MarshMellowHelper
import com.example.newbasicstructure.viewmodel.DemoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val homeViewModel: DemoViewModel by viewModels()
    private var marshMellowHelper: MarshMellowHelper? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        lifecycleScope.launch {
            homeViewModel.getData()
            binding.let {
                it.btnCamera.setOnClickListener {
                    if (!checkPermission(this@MainActivity, CheckPermission.CAMERA)) {
                        initCameraRequestPermission()
                    } else {
                        openCamera()
                    }
                }
                it.btnAudio.setOnClickListener {
                    if (!checkPermission(this@MainActivity, CheckPermission.AUDIO)) {
                        initCameraRequestPermission()
                    } else {
                        openAudio()
                    }
                }
                it.btnGallery.setOnClickListener {
                    if (!checkPermission(this@MainActivity, CheckPermission.STORAGE)) {
                        initCameraRequestPermission()
                    } else {
                        openGallery()
                    }
                }
            }
        }
    }

    private fun openGallery() {

    }

    private fun openAudio() {

    }

    private fun openCamera() {

    }

    private fun initCameraRequestPermission() {
        marshMellowHelper = MarshMellowHelper(
            this, cameraWithStoragePermission,
            RequestCodeUtil.PERMISSIONS_AUDIO_RECORDING_REQUEST_CODE
        )
        marshMellowHelper!!.request(object : MarshMellowHelper.PermissionCallback {
            override fun onPermissionGranted() {
                openCamera()
            }

            override fun onPermissionDenied(permissionDeniedError: String) {
                Toast.makeText(this@MainActivity, permissionDeniedError, Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionDeniedBySystem(permissionDeniedBySystem: String) {
                Toast.makeText(this@MainActivity, permissionDeniedBySystem, Toast.LENGTH_SHORT)
                    .show();
            }
        })
    }
}