package org.amcmobileware.weather.communication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.amcmobileware.weather.models.WeatherModel;

import java.lang.reflect.Type;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.amcmobileware.weather.AppContract.BASE_URL;

/**
 * Created by Arkadiusz Cieśliński on 10/06/2017.
 * - acieslinski@gmail.com
 */

public class WeatherServiceAdapter {
    private final ApiWeatherService apiWeatherService;

    public WeatherServiceAdapter() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging);

        Gson builder = new GsonBuilder()
                .registerTypeAdapter(Date.class, dateJsonDeserializer)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(builder))
                .client(httpClient.build())
                .build();

        apiWeatherService = retrofit.create(ApiWeatherService.class);
    }

    public Call<WeatherModel> loadWeatherModel(String cityName) {
        return apiWeatherService.getWeatherModel(cityName);
    }

    private final JsonDeserializer dateJsonDeserializer = new JsonDeserializer<Date>() {
        public Date deserialize(JsonElement jsonElement, Type type,
                                JsonDeserializationContext context)
                throws JsonParseException {
            return new Date(jsonElement.getAsJsonPrimitive().getAsLong() * 1000L);
        }
    };
}
