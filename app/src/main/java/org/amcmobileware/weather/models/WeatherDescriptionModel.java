package org.amcmobileware.weather.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arkadiusz Cieśliński on 10/06/2017.
 * - acieslinski@gmail.com
 */

public class WeatherDescriptionModel {
    @SerializedName("main")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
