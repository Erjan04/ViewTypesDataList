package com.example.viewtypesdatalist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.example.viewtypesdatalist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter: MainAdapter by lazy {
        MainAdapter()
    }
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val list = ArrayList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initList()
        initRecycler()
    }

    private fun initRecycler() {
        binding.recyclerView.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity, VERTICAL, false)
        }
    }

    private fun initList() {
        list.add(Data(MainAdapter.VIEW_TYPE_ONE, "1"))
        list.add(Data(MainAdapter.VIEW_TYPE_ONE, "1"))
        list.add(Data(MainAdapter.VIEW_TYPE_TWO, "2"))
        list.add(Data(MainAdapter.VIEW_TYPE_ONE, "1"))
        list.add(Data(MainAdapter.VIEW_TYPE_TWO, "2"))
        list.add(Data(MainAdapter.VIEW_TYPE_ONE, "1"))
        list.add(Data(MainAdapter.VIEW_TYPE_ONE, "1"))
        adapter.list = list
    }
}