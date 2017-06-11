package org.amcmobileware.weather.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ObservableList.OnListChangedCallback;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.amcmobileware.weather.R;
import org.amcmobileware.weather.databinding.ComponentItemWeatherRecordBinding;
import org.amcmobileware.weather.viewmodels.WeatherRecordViewModel;

import java.util.List;

/**
 * Created by Arkadiusz Cieśliński on 10/06/2017.
 * - acieslinski@gmail.com
 */

public class WeatherRecordListAdapter extends RecyclerView.Adapter<WeatherRecordListAdapter.ViewHolder> {
    private final List<WeatherRecordViewModel> weatherRecordViewModels;

    public WeatherRecordListAdapter(ObservableList<WeatherRecordViewModel> weatherRecordViewModels) {
        this.weatherRecordViewModels = weatherRecordViewModels;

        weatherRecordViewModels.addOnListChangedCallback(onListChangedCallback);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ComponentItemWeatherRecordBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.component_item_weather_record, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WeatherRecordViewModel model = weatherRecordViewModels.get(position);

        holder.bind(model);

    }

    @Override
    public int getItemCount() {
        return weatherRecordViewModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ComponentItemWeatherRecordBinding binding;

        ViewHolder(ComponentItemWeatherRecordBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(WeatherRecordViewModel viewModel) {
            binding.setVm(viewModel);
        }
    }

    private final OnListChangedCallback<ObservableList<WeatherRecordViewModel>> onListChangedCallback =
            new OnListChangedCallback<ObservableList<WeatherRecordViewModel>>() {
                @Override
                public void onChanged(ObservableList<WeatherRecordViewModel> sender) {
                    notifyDataSetChanged();
                }

                @Override
                public void onItemRangeChanged(ObservableList<WeatherRecordViewModel> sender,
                                               int positionStart, int itemCount) {
                    notifyItemRangeChanged(positionStart, itemCount);
                }

                @Override
                public void onItemRangeInserted(ObservableList<WeatherRecordViewModel> sender,
                                                int positionStart, int itemCount) {
                    notifyItemRangeInserted(positionStart, itemCount);
                }

                @Override
                public void onItemRangeMoved(ObservableList<WeatherRecordViewModel> sender,
                                             int fromPosition, int toPosition, int itemCount) {
                    for (int i = 0; i < itemCount; i++) {
                        notifyItemMoved(fromPosition + i, toPosition + i);
                    }
                }

                @Override
                public void onItemRangeRemoved(ObservableList<WeatherRecordViewModel> sender,
                                               int positionStart, int itemCount) {
                    notifyItemRangeRemoved(positionStart, itemCount);
                }
            };
}
