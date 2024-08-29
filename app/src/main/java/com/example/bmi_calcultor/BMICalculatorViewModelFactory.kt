package com.example.bmi_calcultor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BMICalculatorViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BMICalculatorViewModel::class.java)) {
            return BMICalculatorViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
