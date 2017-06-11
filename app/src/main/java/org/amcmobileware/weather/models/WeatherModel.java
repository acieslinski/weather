package org.amcmobileware.weather.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Arkadiusz Cieśliński on 10/06/2017.
 * - acieslinski@gmail.com
 */

public class WeatherModel {
    @SerializedName("city")
    private CityModel cityModel;
    @SerializedName("list")
    private List<WeatherRecordModel> weatherRecordModel;

    public List<WeatherRecordModel> getWeatherRecordModels() {
        return weatherRecordModel;
    }
}
