package com.Oss.weatherapp.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Oss.weatherapp.repository.Repository
import com.Oss.weatherapp.utils.data.WeatherCallBack
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {
    // TODO: Implement the ViewModel
    val weatherResponse: MutableLiveData<WeatherCallBack> = MutableLiveData()

    fun getCurrentWeather(lat: Double, long: Double) {

        viewModelScope.launch {
            weatherResponse.value = repository.getCurrentTemp(
                lat = lat,
                long = long
            )
        }
    }
}