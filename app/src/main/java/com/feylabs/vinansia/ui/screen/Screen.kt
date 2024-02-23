package com.feylabs.vinansia.ui.screen

sealed class Screen(val route:String){
    object Home:Screen("home")
    object SnipDetail:Screen("snip-detail/{id}")
}