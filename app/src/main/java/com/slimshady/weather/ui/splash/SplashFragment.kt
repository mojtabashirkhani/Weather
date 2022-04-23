package com.slimshady.weather.ui.splash

import android.graphics.Color
import android.view.View
import android.view.WindowManager
import android.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.mikhaellopez.rxanimation.*
import com.slimshady.weather.base.BaseFragment
import com.slimshady.weather.core.Constants
import com.slimshady.weather.databinding.FragmentSplashBinding
import com.slimshady.weather.util.extensions.hide
import com.slimshady.weather.util.extensions.show
import io.reactivex.disposables.CompositeDisposable
import com.slimshady.weather.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashFragmentViewModel, FragmentSplashBinding>(R.layout.fragment_splash, SplashFragmentViewModel::class.java) {

    var disposable = CompositeDisposable()


    override fun initViews() {


        /*  if (mViewDataBinding.viewModel?.sharedPreferences?.getString(Constants.Coords.LON, "").isNullOrEmpty()) {
              mViewDataBinding.buttonExplore.show()
              mViewDataBinding.viewModel?.navigateDashboard = false
          } else {
              mViewDataBinding.buttonExplore.hide()
              mViewDataBinding.viewModel?.navigateDashboard = true
          }*/

        mViewDataBinding.viewModel?.navigateDashboard?.let { startSplashAnimation(it) }

        mViewDataBinding.buttonExplore.setOnClickListener {
            mViewDataBinding.viewModel?.navigateDashboard?.let { it1 -> endSplashAnimation(it1) }
        }

        mViewDataBinding.rootView.setOnClickListener {
            mViewDataBinding.viewModel?.navigateDashboard?.let { it1 -> endSplashAnimation(it1) }
        }
    }

    private fun startSplashAnimation(navigateToDashboard: Boolean) {
        disposable.add(
            RxAnimation.sequentially(
                RxAnimation.together(
                    mViewDataBinding.imageViewBottomDrawable.translationY(500f),
                    mViewDataBinding.imageViewEllipse.fadeOut(0L),
                    mViewDataBinding.imageViewBottomDrawable.fadeOut(0L),
                    mViewDataBinding.imageViewBigCloud.translationX(-500F, 0L),
                    mViewDataBinding.imageViewSmallCloud.translationX(500f, 0L),
                    mViewDataBinding.imageViewBottomDrawableShadow.translationY(500f),
                    mViewDataBinding.imageViewMainCloud.fadeOut(0L),
                    mViewDataBinding.buttonExplore.fadeOut(0L),
                    mViewDataBinding.imageViewBottomDrawableShadow.fadeOut(0L)
                ),

                RxAnimation.together(
                    mViewDataBinding.imageViewBottomDrawable.fadeIn(1000L),
                    mViewDataBinding.imageViewBottomDrawable.translationY(-1f),
                    mViewDataBinding.imageViewBottomDrawableShadow.fadeIn(1250L),
                    mViewDataBinding.imageViewBottomDrawableShadow.translationY(-1f)
                ),

                RxAnimation.together(
                    mViewDataBinding.imageViewEllipse.fadeIn(1000L),
                    mViewDataBinding.imageViewEllipse.translationY(-50F, 1000L)
                ),

                RxAnimation.together(
                    mViewDataBinding.imageViewBigCloud.translationX(-15f, 1000L),
                    mViewDataBinding.imageViewSmallCloud.translationX(25f, 1000L)
                ),

                mViewDataBinding.imageViewMainCloud.fadeIn(500L),
                mViewDataBinding.buttonExplore.fadeIn(1000L)
            ).doOnTerminate {
                findNavController().graph.startDestination = R.id.nav_home // Little bit tricky solution :)
                if (navigateToDashboard)
                    endSplashAnimation(navigateToDashboard)
            }
                .subscribe()
        )
    }

    private fun endSplashAnimation(navigateToDashboard: Boolean) {
        disposable.add(
            RxAnimation.sequentially(
                RxAnimation.together(
                    mViewDataBinding.imageViewBottomDrawable.fadeOut(300L),
                    mViewDataBinding.imageViewBottomDrawable.translationY(100f),
                    mViewDataBinding.imageViewBottomDrawableShadow.fadeOut(300L),
                    mViewDataBinding.imageViewBottomDrawableShadow.translationY(100f)
                ),

                RxAnimation.together(
                    mViewDataBinding.imageViewEllipse.fadeOut(300L),
                    mViewDataBinding.imageViewEllipse.translationY(500F, 300L)
                ),

                RxAnimation.together(
                    mViewDataBinding.imageViewBigCloud.translationX(500f, 300L),
                    mViewDataBinding.imageViewSmallCloud.translationX(-500f, 300L)
                ),

                mViewDataBinding.imageViewMainCloud.fadeOut(300L),
                mViewDataBinding.buttonExplore.fadeOut(300L),
                mViewDataBinding.rootView.backgroundColor(
                    Color.parseColor("#5D50FE"),
                    Color.parseColor("#FFFFFF"),
                    duration = 750L
                )
            )
                .doOnTerminate {
                    findNavController().graph.startDestination = R.id.nav_home // Little bit tricky solution :)
                    if (navigateToDashboard)
                        navigate(R.id.action_splashFragment_to_homeFragment)
                    else
                        navigate(R.id.action_splashFragment_to_searchFragment)
                }
                .subscribe()

        )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}
