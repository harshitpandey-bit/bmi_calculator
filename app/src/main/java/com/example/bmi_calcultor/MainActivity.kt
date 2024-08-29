package com.example.bmi_calcultor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.bmi_calcultor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: BMICalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Initialize ViewModel and Factory
        val factory = BMICalculatorViewModelFactory()
        viewModel = ViewModelProvider(this, factory)[BMICalculatorViewModel::class.java]

        // Bind ViewModel to layout
        binding.bmiViewModel = viewModel
        binding.lifecycleOwner = this

        // Observers
        viewModel.bmiResult.observe(this) { result ->
            binding.bmiTextView.text = result
        }

        viewModel.status.observe(this) { status ->
            binding.statusTextView.text = status
        }

        viewModel.isResetMode.observe(this) { isResetMode ->
            binding.calculateButton.text = if (isResetMode) "Reset" else "Calculate BMI"
        }
    }
}
