package com.mshetty.instagramcompose.data

import com.mshetty.instagramcompose.R
import com.mshetty.instagramcompose.util.AppConstant

sealed class BottomNavItem(val icon:Int,val route:String) {
    object Home : BottomNavItem(icon = R.drawable.ic_baseline_home_24, route = AppConstant.HOME)
    object SEARCH : BottomNavItem(icon = R.drawable.ic_baseline_search_24, route = AppConstant.SEARCH)
    object PROFILE : BottomNavItem(icon = R.drawable.ic_baseline_account_circle_24, route = AppConstant.PROFILE)

}
