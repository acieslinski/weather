package org.amcmobileware.weather.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arkadiusz Cieśliński on 10/06/2017.
 * - acieslinski@gmail.com
 */

public class WeatherDetailsModel {
    @SerializedName("temp")
    private float temparature;
    @SerializedName("temp_min")
    private float temperatureMin;
    @SerializedName("temp_max")
    private float temperatureMax;

    public float getTemparature() {
        return temparature;
    }
}
