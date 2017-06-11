package org.amcmobileware.weather.adapters;

import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.amcmobileware.weather.viewmodels.WeatherRecordViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.amcmobileware.weather.AppContract.BASE_URL;

/**
 * Created by Arkadiusz Cieśliński on 10/06/2017.
 * - acieslinski@gmail.com
 */

public class BindingAdapter {
    @android.databinding.BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView,
                                             ObservableList<WeatherRecordViewModel> weatherRecordModels) {
        recyclerView.setAdapter(new WeatherRecordListAdapter(weatherRecordModels));
    }

    @android.databinding.BindingAdapter("iconCode")
    public static void setIconCode(ImageView imageView, String iconCode) {
        Picasso.with(imageView.getContext())
                .load(BASE_URL + "/img/w/" + iconCode + ".png")
                .into(imageView);
    }
}
