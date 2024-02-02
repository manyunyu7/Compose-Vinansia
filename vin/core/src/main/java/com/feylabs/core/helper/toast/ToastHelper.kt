package com.feylabs.core.helper.toast

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

object ToastHelper {
    /**
     * Displays a short duration Toast message with the given message text.
     *
     * @param context the Context in which to display the Toast.
     * @param message the message to display.
     */
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Displays a long duration Toast message with the given message text.
     *
     * @param context the Context in which to display the Toast.
     * @param message the message to display.
     */
    fun showToastLong(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }


    /**
     * Displays a short duration Toast message with the given message text.
     *
     * @param message the message to display.
     */
    fun Activity.showToast(message: String) {
        ToastHelper.showToast(this, message)
    }

    /**
     * Displays a long duration Toast message with the given message text.
     *
     * @param message the message to display.
     */
    fun Activity.showToastLong(message: String) {
        ToastHelper.showToastLong(this, message)
    }

    /**
     * Displays a short duration Toast message with the given message text.
     *
     * @param message the message to display.
     */
    fun Fragment.showToast(message: String) {
        ToastHelper.showToast(requireContext(), message)
    }

    /**
     * Displays a long duration Toast message with the given message text.
     *
     * @param message the message to display.
     */
    fun Fragment.showToastLong(message: String) {
        ToastHelper.showToastLong(requireContext(), message)
    }

}
