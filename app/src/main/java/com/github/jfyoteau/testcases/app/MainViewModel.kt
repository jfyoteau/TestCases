package com.github.jfyoteau.testcases.app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var id = 0;
    private val list = mutableListOf<Item>()
    private val imageList = listOf(R.drawable.chat_perdu, R.drawable.chat_yeux_final, R.drawable.petit_chat)

    val displayedImageList = MutableLiveData(listOf<Item>())

    fun addItem() {
        this.id++
        val item = Item(
            id = this.id,
            image = imageList[this.id % imageList.size]
        )
        this.list.add(item)
        displayList()
    }

    fun deleteItem(item: Item) {
        this.list.remove(item)
        displayList()
    }

    private fun displayList() {
        displayedImageList.value = list.map { it.copy() }
    }
}
