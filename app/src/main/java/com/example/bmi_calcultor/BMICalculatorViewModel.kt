package com.example.bmi_calcultor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BMICalculatorViewModel : ViewModel() {

    private val _height = MutableLiveData<String>()
    val height: LiveData<String> get() = _height

    private val _weight = MutableLiveData<String>()
    val weight: LiveData<String> get() = _weight

    private val _bmiResult = MutableLiveData<String>()
    val bmiResult: LiveData<String> get() = _bmiResult

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> get() = _status

    private val _isResetMode = MutableLiveData<Boolean>(false)
    val isResetMode: LiveData<Boolean> get() = _isResetMode

    private var isMale: Boolean = true

    fun onGenderSelected(gender: String) {
        isMale = gender == "Male"
    }

    fun calculateBMI() {
        val heightValue = _height.value?.toDoubleOrNull()
        val weightValue = _weight.value?.toDoubleOrNull()

        if (heightValue != null && weightValue != null && heightValue > 0) {
            val bmi = weightValue / (heightValue * heightValue)
            _bmiResult.value = "BMI: %.2f".format(bmi)

            _status.value = when {
                bmi < 18.5 -> "Underweight"
                bmi in 18.5..24.9 -> "Normal weight"
                bmi in 25.0..29.9 -> "Overweight"
                else -> "Obesity"
            }

            _isResetMode.value = true
        }
    }

    fun resetFields() {
        _height.value = ""
        _weight.value = ""
        _bmiResult.value = ""
        _status.value = ""
        _isResetMode.value = false
    }
}
