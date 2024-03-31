package com.Oss.weatherapp.home.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.Oss.weatherapp.R
import com.Oss.weatherapp.home.viewModel.HomeViewModel
import com.Oss.weatherapp.home.viewModel.HomeViewModelFactory
import com.Oss.weatherapp.repository.Repository

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repo = Repository()
        val viewModelFactory = HomeViewModelFactory(repo)
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]

        viewModel.getCurrentWeather(lat = 44.34, long = 10.99)
        viewModel.weatherResponse.observe(this, Observer {
            Log.d("Current Weather", it.toString())
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}