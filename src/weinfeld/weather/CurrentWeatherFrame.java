package weinfeld.weather;

import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CurrentWeatherFrame extends JFrame {

    URL url = new URL("https://api.openweathermap.org/data/2.5/weather?zip=60645&appid=a7b6239e49fd13f9be40d247fae3d6c2&units=imperial");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    InputStream in = connection.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    Gson gson = new Gson();
    CurrentWeather currentWeather = gson.fromJson(reader, CurrentWeather.class);

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
        place = new JLabel("     " + currentWeather.name);
        temp = new JLabel("     " + currentWeather.main);
        main = new JLabel("     " + currentWeather.weather[0]);
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
        String newZip = zip.getText();
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?zip="+ newZip +"&appid=a7b6239e49fd13f9be40d247fae3d6c2&units=imperial");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Gson gson = new Gson();
        CurrentWeather currentWeather = gson.fromJson(reader, CurrentWeather.class);
        place.setText("     " + currentWeather.name);
        temp.setText("     " + currentWeather.main);
        main.setText("     " + currentWeather.weather[0]);
        zip.setText("");
    }

    public static void main(String[] args) throws IOException {

        new CurrentWeatherFrame().setVisible(true);
    }

}
