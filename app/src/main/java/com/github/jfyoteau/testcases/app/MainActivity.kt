package com.github.jfyoteau.testcases.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.github.jfyoteau.testcases.app.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var listAdapter: GridRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model: MainViewModel by viewModels()
        with(binding) {
            with(recyclerview) {
                layoutManager = GridLayoutManager(this@MainActivity, 2)
                adapter = GridRecyclerViewAdapter(OnActionListener { item, _ ->
                    model.deleteItem(item)
                }).also { listAdapter = it }
            }
            addButton.setOnClickListener {
                model.addItem()
            }
        }

        model.displayedImageList.observe(this, Observer {
            this.listAdapter.submitList(it)
        })
    }
}
