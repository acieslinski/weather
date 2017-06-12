package org.amcmobileware.weather.viewmodels;

import junit.framework.Assert;

import org.amcmobileware.weather.models.WeatherDetailsModel;
import org.amcmobileware.weather.models.WeatherRecordModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static org.amcmobileware.weather.AppContract.DEGREES;
import static org.mockito.Mockito.when;

/**
 * Created by Arkadiusz Cieśliński on 12/06/2017.
 * - acieslinski@gmail.com
 */

public class WeatherRecordViewModelTests {

    @Before
    public void setUp() {
        Locale.setDefault(Locale.UK);
        TimeZone.setDefault(TimeZone.getTimeZone("UK"));
    }

    @Test
    public void constructingWithWeatherRecordModelWithNulls() {
        WeatherRecordModel weatherRecordModel = new WeatherRecordModel();

        WeatherRecordViewModel weatherRecordViewModel = new WeatherRecordViewModel(
                weatherRecordModel);

        Assert.assertEquals("", weatherRecordViewModel.getTitle());
        Assert.assertEquals("", weatherRecordViewModel.getDescription());
        Assert.assertEquals("", weatherRecordViewModel.getDate());
        Assert.assertEquals("", weatherRecordViewModel.getIconCode());
        Assert.assertEquals("", weatherRecordViewModel.getTemperature());
    }

    @Test
    public void constructingWithStandardValues() {
        WeatherRecordModel weatherRecordModelMock = Mockito.mock(WeatherRecordModel.class);
        WeatherDetailsModel weatherDetailsModelMock = Mockito.mock(WeatherDetailsModel.class);

        when(weatherRecordModelMock.getDate()).thenReturn(new Date(1497292200000L));
        when(weatherRecordModelMock.getWeatherDetailsModel()).thenReturn(weatherDetailsModelMock);

        when(weatherDetailsModelMock.getTemparature()).thenReturn(23.45F);

        WeatherRecordViewModel weatherRecordViewModel = new WeatherRecordViewModel(
                weatherRecordModelMock);

        Assert.assertEquals("23.45" + DEGREES, weatherRecordViewModel.getTemperature());
        Assert.assertEquals("12-06-2017\n06:30 PM", weatherRecordViewModel.getDate());

        // TODO test title and description
    }
}
