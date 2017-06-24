package lol.ye0yeg.lolweather.api;

import lol.ye0yeg.lolweather.bean.WeatherXml;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Administrator on 6/23/2017.
 */

public interface XmlApiService {

    @GET("xml.php")
    rx.Observable<WeatherXml> getWData(
            @Header("Cache-Control") String cacheControl,
            @Query(value = "city", encoded = true) String myCity,
            @Query("password") String myPassword,
            @Query("day") String myDay);
}
