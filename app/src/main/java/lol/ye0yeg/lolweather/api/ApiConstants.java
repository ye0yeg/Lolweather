package lol.ye0yeg.lolweather.api;

/**
 * Created by Administrator on 6/23/2017.
 */
public class ApiConstants {
    private static final String WEATHER_URL = "http://php.weather.sina.com.cn/";
    public static final String WD_URL = "https://xandone-weather.wilddogio.com";
    /**
     * 获取对应的host
     *
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case HostType.MY_WEATHER:
                host = WEATHER_URL;
                break;
            default:
                host = "";
                break;
        }
        return host;
    }
}
