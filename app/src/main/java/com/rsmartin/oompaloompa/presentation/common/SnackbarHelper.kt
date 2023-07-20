package com.rsmartin.oompaloompa.presentation.common

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.rsmartin.oompaloompa.R

class SnackbarHelper {

    enum class Type { INFO, WARNING, ERROR }

    companion object {
        fun showSnackbar(
            context: Context,
            parent: View,
            message: Int,
            type: Type,
            actionText: Int? = null,
            actionCallback: ActionCallback? = null,
        ) {
            val msg = context.getString(message)
            showSnackbar(context, parent, msg, type, actionText, actionCallback)
        }

        fun showSnackbar(
            context: Context,
            parent: View,
            message: String,
            type: Type,
            actionText: Int? = null,
            actionCallback: ActionCallback? = null
        ) {
            val snackbar = Snackbar.make(
                parent,
                message,
                getDuration(actionText)
            )

            with(snackbar) {
                if (actionText != null) {
                    setAction(context.getString(actionText)) {
                        actionCallback?.doAction()
                    }
                    setActionTextColor(ContextCompat.getColor(context, R.color.white))
                }
                view.setBackgroundColor(getBackgroundColor(context, type))
                show()
            }
        }

        private fun getDuration(actionText: Int?): Int {
            return if (actionText != null) Snackbar.LENGTH_INDEFINITE else Snackbar.LENGTH_SHORT
        }

        private fun getBackgroundColor(context: Context, type: Type): Int {
            val color = when (type) {
                Type.INFO -> R.color.colorAccentVariant
                Type.WARNING -> R.color.colorWarning
                Type.ERROR -> R.color.colorPrimaryVariant
            }
            return ContextCompat.getColor(context, color)
        }
    }

    interface ActionCallback {
        fun doAction()
    }

}