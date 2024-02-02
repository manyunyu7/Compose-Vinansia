package com.feylabs.core.helper.view

import android.view.View
import androidx.viewbinding.ViewBinding


object ViewUtils {
    fun View.visible() {
        visibility = View.VISIBLE
    }

    fun View.invisible() {
        visibility = View.INVISIBLE
    }

    fun View.gone() {
        visibility = View.GONE
    }

    fun View.enable() {
        isEnabled = true
    }

    fun View.disable() {
        isEnabled = false
    }

    /**
     * Shows this view binding by setting its visibility to VISIBLE.
     */
    fun <T : ViewBinding> T.visible(): T {
        this.root.visibility = View.VISIBLE
        return this
    }

    /**
     * Hides this view binding by setting its visibility to GONE.
     */
    fun <T : ViewBinding> T.gone(): T {
        this.root.visibility = View.GONE
        return this
    }
}