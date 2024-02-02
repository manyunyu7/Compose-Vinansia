package com.feylabs.core.helper.snackbar

import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

object SnackbarHelper {
    /**
     * Displays a Snackbar with the given message text and duration.
     *
     * @param view the View to attach the Snackbar to.
     * @param message the message to display.
     * @param duration the duration of the Snackbar.
     * @param actionText optional text for the Snackbar action.
     * @param actionListener optional click listener for the Snackbar action.
     */
    fun showSnackbar(
        view: View,
        message: String,
        duration: Int = Snackbar.LENGTH_SHORT,
        actionText: String? = null,
        actionListener: View.OnClickListener? = null
    ) {
        val snackbar = Snackbar.make(view, message, duration)
        if (actionText != null && actionListener != null) {
            snackbar.setAction(actionText, actionListener)
        }
        snackbar.show()
    }

    /**
     * Displays a Snackbar with the given message resource ID and duration.
     *
     * @param view the View to attach the Snackbar to.
     * @param messageId the resource ID of the message to display.
     * @param duration the duration of the Snackbar.
     * @param actionText optional text for the Snackbar action.
     * @param actionListener optional click listener for the Snackbar action.
     */
    fun showSnackbar(
        view: View,
        @StringRes messageId: Int,
        duration: Int = Snackbar.LENGTH_SHORT,
        actionText: String? = null,
        actionListener: View.OnClickListener? = null
    ) {
        showSnackbar(view, view.resources.getString(messageId), duration, actionText, actionListener)
    }

}