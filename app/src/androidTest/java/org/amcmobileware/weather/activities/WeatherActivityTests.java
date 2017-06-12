package org.amcmobileware.weather.activities;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import org.amcmobileware.weather.R;
import org.amcmobileware.weather.databinding.ActivityWeatherBinding;
import org.amcmobileware.weather.viewmodels.WeatherRecordViewModel;
import org.amcmobileware.weather.viewmodels.WeatherViewModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

/**
 * Created by Arkadiusz Cieśliński on 12/06/2017.
 * - acieslinski@gmail.com
 */

@RunWith(AndroidJUnit4.class)
public class WeatherActivityTests {
    private static final int ITEM_COUNT = 10;

    @Rule
    public ActivityTestRule<WeatherActivity> activityTestRule =
            new ActivityTestRule<>(WeatherActivity.class);

    private LayoutInflater inflater;

    @Before
    public void setup() throws Exception {
        inflater = LayoutInflater.from(activityTestRule.getActivity());
    }

    @Test
    @UiThreadTest
    public void testRecyclerViewItemCount() {
        WeatherViewModel weatherViewModelMock = Mockito.mock(WeatherViewModel.class);
        WeatherRecordViewModel weatherRecordViewModelMock = Mockito.mock(
                WeatherRecordViewModel.class);
        ObservableList<WeatherRecordViewModel> weatherRecordViewModels =
                new ObservableArrayList<>();

        for (int i = 0; i < ITEM_COUNT; i++) {
            weatherRecordViewModels.add(weatherRecordViewModelMock);
        }

        when(weatherViewModelMock.getWeatherRecordViewModels()).thenReturn(weatherRecordViewModels);

        ActivityWeatherBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.activity_weather, null, false);
        binding.setVm(weatherViewModelMock);
        binding.executePendingBindings();

        RecyclerView.Adapter adapter = binding.rvWeatherRecords.getAdapter();

        Assert.assertEquals(ITEM_COUNT, adapter.getItemCount());
    }
}
