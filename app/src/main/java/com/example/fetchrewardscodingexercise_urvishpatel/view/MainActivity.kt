package com.example.fetchrewardscodingexercise_urvishpatel.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.fetchrewardscodingexercise_urvishpatel.R
import com.example.fetchrewardscodingexercise_urvishpatel.adapter.RvAdapter
import com.example.fetchrewardscodingexercise_urvishpatel.data.DataResponseItem
import com.example.fetchrewardscodingexercise_urvishpatel.databinding.ActivityMainBinding
import com.example.fetchrewardscodingexercise_urvishpatel.repo.Repository
import com.example.fetchrewardscodingexercise_urvishpatel.viewmodel.MainViewModel
import com.example.fetchrewardscodingexercise_urvishpatel.viewmodel.MainViewModelFactory


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var adapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // initialize view-model
        initViewModel()
        //making function call to get the data from repository
        initFunctionCall()
        //observe live data from view-model
        initObserver()
    }

    private fun initObserver() {
        viewModel.message.observe(this) {
            Toast.makeText(baseContext, it, Toast.LENGTH_SHORT).show()
        }
        viewModel.data.observe(this) {
            adapter = RvAdapter(it)
            binding.rvItem.adapter = adapter
        }
    }

    private fun initFunctionCall() {
        viewModel.getDataVM()
    }

    private fun initViewModel() {
        val factory = MainViewModelFactory(Repository())
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }
}