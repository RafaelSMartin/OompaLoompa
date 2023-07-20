package com.rsmartin.oompaloompa.presentation.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.rsmartin.oompaloompa.R

class LoadingDialog {

    companion object {
        private var instance: AlertDialog? = null
        private var animation: LottieAnimationView? = null

        fun show(context: Context, mustShow: Boolean) {
            if (mustShow) {
                show(context)
            } else {
                hide()
            }
        }

        private fun show(context: Context) {
            val builder: AlertDialog.Builder = AlertDialog.Builder(context, R.style.LoadingDialog)
            val customLayout: View = LayoutInflater.from(context)
                .inflate(R.layout.loading_dialog, null)
            animation = customLayout.findViewById(R.id.loadingAnimation)
            animation?.setAnimation(R.raw.loading)
            animation?.repeatCount = 1000
            animation?.repeatMode = LottieDrawable.REVERSE
            builder.setView(customLayout)
            builder.setCancelable(false)
            instance = builder.create()

            animation?.playAnimation()
            instance?.show()
        }

        private fun hide() {
            animation?.cancelAnimation()
            instance?.dismiss()
        }
    }

}