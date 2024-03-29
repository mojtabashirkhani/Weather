package com.slimshady.weather.base

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil.inflate
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

abstract class BaseFragment<V: ViewModel, T: ViewDataBinding>(@LayoutRes val layout: Int, viewModelClass: Class<V>) : Fragment() {


    lateinit var mViewDataBinding: T
    private lateinit var permissionCallback: (Array<BasePermissionModel>) -> Unit


    abstract fun initViews()

    private val mViewModel by lazy {
        ViewModelProvider(this).get(viewModelClass)
    }

    override fun onAttach(context: Context) {

        super.onAttach(context)
//        mViewModel = getViewModel()

    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onCreateView(
        @NonNull inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mViewDataBinding = inflate(inflater, layout, container, false)

        return  mViewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        this.mViewModel = if (mViewModel == null) getViewModel() else mViewModel
        mViewDataBinding.setVariable(BR.viewModel, mViewModel)
        mViewDataBinding.lifecycleOwner = this
        mViewDataBinding.executePendingBindings()

        initViews()

    }

    fun getViewDataBinding(): T {
        return mViewDataBinding
    }


    fun checkPermissions(permission: String, fn: (Array<BasePermissionModel>) -> Unit) {
        val permissions = arrayOf(permission)
        checkPermissions(permissions, fn)
    }

    fun checkPermissions(permissions: Array<String>, fn: (Array<BasePermissionModel>) -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, PERMISSION_REQUEST_CODE)
            permissionCallback = fn
        } else {

            val permissionResults = arrayListOf<BasePermissionModel>()

            permissions.forEachIndexed { _, permission ->

                permissionResults.add(
                    BasePermissionModel(
                    permission, true
                )
                )

            }

            fn(permissionResults.toTypedArray())

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                                            grantResults: IntArray) {
        if (requestCode == PERMISSION_REQUEST_CODE) {

            val permissionResults = arrayListOf<BasePermissionModel>()

            permissions.forEachIndexed { index, permission ->

                permissionResults.add(
                    BasePermissionModel(
                    permission, grantResults[index] == PackageManager.PERMISSION_GRANTED
                )
                )

            }

            permissionCallback(permissionResults.toTypedArray())

        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }
    open fun navigate(action: Int) {
        view?.let { _view ->
            Navigation.findNavController(_view).navigate(action)
        }
    }

    open fun navigate(action: Int, bundle: Bundle) {
        view?.let { _view ->
            Navigation.findNavController(_view).navigate(action, bundle)
        }
    }

    open fun navigate(action: NavDirections) {
        view?.let { _view ->
            Navigation.findNavController(_view).navigate(action)
        }
    }


    companion object {
        private const val PERMISSION_REQUEST_CODE = 9824
    }


}