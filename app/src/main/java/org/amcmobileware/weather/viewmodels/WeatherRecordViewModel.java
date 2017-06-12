package org.amcmobileware.weather.viewmodels;

import org.amcmobileware.weather.models.WeatherDescriptionModel;
import org.amcmobileware.weather.models.WeatherRecordModel;

import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.amcmobileware.weather.AppContract.DEGREES;

/**
 * Created by Arkadiusz Cieśliński on 10/06/2017.
 * - acieslinski@gmail.com
 */

public class WeatherRecordViewModel {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(
            "dd-MM-yyyy\nhh:mm a", Locale.getDefault());

    private final String title;
    private final String description;
    private final String temperature;
    private final String iconCode;
    private final String date;

    WeatherRecordViewModel(WeatherRecordModel weatherRecordModel) {
        StringBuilder title = new StringBuilder();
        StringBuilder description = new StringBuilder();
        String iconCode = "";

        for (WeatherDescriptionModel model : weatherRecordModel.getWeatherDescription()) {
            title.append(model.getTitle()).append(" ");
            description.append(model.getDescription()).append(" ");
            iconCode = model.getIcon();
        }

        this.title = title.toString();
        this.description = description.toString();
        this.temperature = String.valueOf(weatherRecordModel.getWeatherDetailsModel().
                getTemparature()) + DEGREES;
        this.iconCode = iconCode;
        this.date = SIMPLE_DATE_FORMAT.format(weatherRecordModel.getDate());
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getIconCode() {
        return iconCode;
    }

    public String getDate() {
        return date;
    }
}
