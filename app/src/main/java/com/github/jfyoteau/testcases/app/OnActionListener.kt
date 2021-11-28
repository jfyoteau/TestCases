package com.github.jfyoteau.testcases.app

class OnActionListener<T>(val actionListener: (item: T, position: Int) -> Unit) {
    fun onAction(item: T, position: Int) = actionListener(item, position)
}
