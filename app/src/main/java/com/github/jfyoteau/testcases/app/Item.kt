package com.github.jfyoteau.testcases.app

import androidx.annotation.DrawableRes

data class Item(
    val id: Int,
    @DrawableRes val image: Int
)
