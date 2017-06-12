package org.amcmobileware.weather.viewmodels;

import org.amcmobileware.weather.models.WeatherModel;
import org.amcmobileware.weather.models.WeatherRecordModel;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import retrofit2.Call;
import retrofit2.Response;

import static org.mockito.Mockito.when;

/**
 * Created by Arkadiusz Cieśliński on 12/06/2017.
 * - acieslinski@gmail.com
 */
@RunWith(MockitoJUnitRunner.class)
public class WeatherViewModelTests {

    @Mock
    private WeatherModel weatherModelMock;
    @Mock
    private Call<WeatherModel> weatherModelCallMock;
    @Mock
    private WeatherRecordModel weatherRecordModelMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void responseWithNullBody() {
        WeatherViewModel weatherViewModel = new WeatherViewModel();
        Response<WeatherModel> weatherModelResponse = Response.success(null);

        weatherViewModel.onResponse(weatherModelCallMock, weatherModelResponse);
    }

    @Test
    public void responseWithWeatherModelWithNulls() {
        WeatherModel weatherModel = new WeatherModel();
        WeatherViewModel weatherViewModel = new WeatherViewModel();
        Response<WeatherModel> weatherModelResponse = Response.success(weatherModel);

        weatherViewModel.onResponse(weatherModelCallMock, weatherModelResponse);
    }
}
