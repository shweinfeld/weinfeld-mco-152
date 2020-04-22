package weinfeld.weather;

import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;


public class GetCurrentWeather {


    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);

        service.getThisZip("08002").enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                CurrentWeather currentWeather = response.body();
                System.out.println(currentWeather.name);
                System.out.println(currentWeather.main);
                System.out.println(currentWeather.weather[0]);

            }
            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

}

