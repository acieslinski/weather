package org.amcmobileware.weather.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by Arkadiusz Cieśliński on 10/06/2017.
 * - acieslinski@gmail.com
 */

public class WeatherRecordModel {
    @SerializedName("dt")
    private Date date;
    @SerializedName("main")
    private WeatherDetailsModel weatherDetailsModel;
    @SerializedName("weather")
    private List<WeatherDescriptionModel> weatherDescription;

    public Date getDate() {
        return date;
    }

    public List<WeatherDescriptionModel> getWeatherDescription() {
        return weatherDescription;
    }

    public WeatherDetailsModel getWeatherDetailsModel() {
        return weatherDetailsModel;
    }
}
