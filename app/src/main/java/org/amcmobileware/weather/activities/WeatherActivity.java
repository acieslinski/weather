package org.amcmobileware.weather.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.amcmobileware.weather.R;
import org.amcmobileware.weather.databinding.ActivityWeatherBinding;
import org.amcmobileware.weather.viewmodels.WeatherViewModel;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final WeatherViewModel viewModel = new WeatherViewModel();

        final ActivityWeatherBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_weather);

        binding.setVm(viewModel);
    }
}
