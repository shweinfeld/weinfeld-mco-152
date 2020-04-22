package weinfeld.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("data/2.5/weather?appid=a7b6239e49fd13f9be40d247fae3d6c2&units=imperial")
    Call<CurrentWeather> getThisZip(@Query("zip") String newZip);

    //@Path("newZip") String newZip
}
