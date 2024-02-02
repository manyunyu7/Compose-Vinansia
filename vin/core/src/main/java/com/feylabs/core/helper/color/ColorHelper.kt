package com.feylabs.core.helper.color

import android.graphics.Color
import kotlin.math.roundToInt

object ColorHelper {
    /**
     * Converts a color string to an integer value.
     *
     * @param colorString the color string to convert (e.g. "#FF0000").
     * @return the integer value of the color.
     */
    fun parseColor(colorString: String): Int {
        return Color.parseColor(colorString)
    }

    /**
     * Darkens a color by a given factor.
     *
     * @param color the color to darken.
     * @param factor the factor by which to darken the color (0.0 - 1.0).
     * @return the darkened color.
     */
    fun darkenColor(color: Int, factor: Float): Int {
        val hsv = FloatArray(3)
        Color.colorToHSV(color, hsv)
        hsv[2] *= factor
        return Color.HSVToColor(hsv)
    }

    /**
     * Lightens a color by a given factor.
     *
     * @param color the color to lighten.
     * @param factor the factor by which to lighten the color (0.0 - 1.0).
     * @return the lightened color.
     */
    fun lightenColor(color: Int, factor: Float): Int {
        val hsv = FloatArray(3)
        Color.colorToHSV(color, hsv)
        hsv[2] += (1 - hsv[2]) * factor
        return Color.HSVToColor(hsv)
    }

    /**
     * Adjusts the alpha value of a color.
     *
     * @param color the color to adjust.
     * @param factor the factor by which to adjust the alpha value (0.0 - 1.0).
     * @return the adjusted color.
     */
    fun adjustAlpha(color: Int, factor: Float): Int {
        val alpha = (Color.alpha(color) * factor).roundToInt()
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)
        return Color.argb(alpha, red, green, blue)
    }
}