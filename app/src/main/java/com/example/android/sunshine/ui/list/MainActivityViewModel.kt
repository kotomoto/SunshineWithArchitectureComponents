package com.example.android.sunshine.ui.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.android.sunshine.data.SunshineRepository
import com.example.android.sunshine.data.database.ListWeatherEntry
import com.example.android.sunshine.data.database.WeatherEntry


class MainActivityViewModel(repository: SunshineRepository) : ViewModel() {
    private val forecast: LiveData<List<ListWeatherEntry>> = repository.currentWeatherForecasts

    fun getForecast(): LiveData<List<ListWeatherEntry>> {
        return forecast
    }
}