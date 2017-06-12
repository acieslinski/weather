package org.amcmobileware.weather.viewmodels;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.util.Log;

import org.amcmobileware.weather.communication.WeatherServiceAdapter;
import org.amcmobileware.weather.models.WeatherModel;
import org.amcmobileware.weather.models.WeatherRecordModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Arkadiusz Cieśliński on 10/06/2017.
 * - acieslinski@gmail.com
 */

public class WeatherViewModel implements Callback<WeatherModel> {
    private final ObservableList<WeatherRecordViewModel> weatherRecordViewModels;
    private final ObservableField<String> city;

    public WeatherViewModel() {
        weatherRecordViewModels = new ObservableArrayList<>();
        city = new ObservableField<>();
    }

    public void onLoadWeatherButtonClick() {
        WeatherServiceAdapter adapter = new WeatherServiceAdapter();

        adapter.loadWeatherModel(city.get()).enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call<WeatherModel> call,
                           @NonNull Response<WeatherModel> response) {
        if (response.isSuccessful()) {
            WeatherModel weatherModel = response.body();

            weatherRecordViewModels.clear();

            for (WeatherRecordModel model : weatherModel.getWeatherRecordModels()) {
                WeatherRecordViewModel viewModel = new WeatherRecordViewModel(model);

                weatherRecordViewModels.add(viewModel);
            }
        } else {
            // TODO handle the fail state
        }
    }

    @Override
    public void onFailure(@NonNull Call<WeatherModel> call, @NonNull Throwable t) {
        Log.e("retrofit", Log.getStackTraceString(t));
    }

    public ObservableList<WeatherRecordViewModel> getWeatherRecordViewModels() {
        return weatherRecordViewModels;
    }

    public ObservableField<String> getCity() {
        return city;
    }
}
