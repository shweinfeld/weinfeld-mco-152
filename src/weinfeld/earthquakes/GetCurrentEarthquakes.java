package weinfeld.earthquakes;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetCurrentEarthquakes {

    public static void main(String[] args) throws IOException {

                URL url = new URL("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/significant_month.geojson");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream in = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                Gson gson = new Gson();
                CurrentEarthquakes currentEarthQuakes = gson.fromJson(reader, CurrentEarthquakes.class);

                for (CurrentEarthquakes.Feature feature: currentEarthQuakes.features) {
                    System.out.println(feature.properties.toString());
                }
            }
        }


