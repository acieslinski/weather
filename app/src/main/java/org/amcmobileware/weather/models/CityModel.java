package org.amcmobileware.weather.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arkadiusz Cieśliński on 10/06/2017.
 * - acieslinski@gmail.com
 */

public class CityModel {
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private String countryCode;
}
