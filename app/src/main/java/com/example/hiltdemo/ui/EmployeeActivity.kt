package com.example.hiltdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiltdemo.R
import com.example.hiltdemo.other.Status
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_employee.*

@AndroidEntryPoint
class EmployeeActivity : AppCompatActivity() {
    private val mainViewModel: EmployeeViewModel by viewModels()
    private lateinit var eAdapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)

        eAdapter = EmployeeAdapter()
        rvEmployees.apply {
            layoutManager = LinearLayoutManager(this@EmployeeActivity)
            adapter = adapter
        }

        mainViewModel.res.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progress.visibility = View.GONE
                    rvEmployees.visibility = View.VISIBLE
                    it.data.let { res ->
                        if (res?.status == "success") {
                            res.data?.let { it1 -> eAdapter.submitList(it1) }
                        } else {
                            Snackbar.make(rootView, "Status = false", Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
                Status.LOADING -> {
                    progress.visibility = View.VISIBLE
                    rvEmployees.visibility = View.GONE
                }
                Status.ERROR -> {
                    progress.visibility = View.GONE
                    rvEmployees.visibility = View.VISIBLE
                    Snackbar.make(rootView, "Something went wrong", Snackbar.LENGTH_SHORT).show()
                }
            }
        })
    }
}