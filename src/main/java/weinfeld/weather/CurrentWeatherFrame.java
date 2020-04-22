package weinfeld.weather;

import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CurrentWeatherFrame extends JFrame {


    private JLabel place;
    private JLabel temp;
    private JLabel main;
    private JPanel display;
    private JLabel zipLabel;
    private JTextField zip;
    private JButton enterZip;
    private JPanel leftPanel;

    public CurrentWeatherFrame() throws IOException {
        setSize(150, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle( "WEATHER");

        setLayout(new BorderLayout());
        display = new JPanel();
        display.setLayout(new BoxLayout(display, BoxLayout.Y_AXIS));
        place = new JLabel();
        temp = new JLabel();
        main = new JLabel();
        display.add(place);
        display.add(temp);
        display.add(main);
        add(display, BorderLayout.CENTER);

        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        zipLabel = new JLabel("Zip Code: ");
        zip = new JTextField();
        enterZip = new JButton("Enter");
        enterZip.addActionListener(actionEvent -> {
            try {
                setZip();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        leftPanel.add(zipLabel);
        leftPanel.add(zip);
        leftPanel.add(enterZip);
        leftPanel.setSize(100, 100);
        add(leftPanel, BorderLayout.WEST);

    }

    private void setZip() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);

        service.getThisZip(zip.getText()).enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                CurrentWeather currentWeather = response.body();
                place.setText("     " + currentWeather.name);
                temp.setText("     " + currentWeather.main);
                main.setText("     " + currentWeather.weather[0]);
                zip.setText("");

            }
            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    public static void main(String[] args) throws IOException {

        new CurrentWeatherFrame().setVisible(true);
    }

}
