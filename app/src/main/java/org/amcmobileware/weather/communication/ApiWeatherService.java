package org.amcmobileware.weather.communication;

import org.amcmobileware.weather.models.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static org.amcmobileware.weather.AppContract.API_KEY;
import static org.amcmobileware.weather.AppContract.DEGREES_UNITS;

/**
 * Created by Arkadiusz Cieśliński on 10/06/2017.
 * - acieslinski@gmail.com
 */

interface ApiWeatherService {
    @GET("/data/2.5/forecast?&appid=" + API_KEY + "&units=" + DEGREES_UNITS)
    Call<WeatherModel> getWeatherModel(@Query("q") String cityName);
}
