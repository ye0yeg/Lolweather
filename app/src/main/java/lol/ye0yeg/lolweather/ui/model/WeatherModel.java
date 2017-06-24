package lol.ye0yeg.lolweather.ui.model;

import lol.ye0yeg.lolweather.api.Api;
import lol.ye0yeg.lolweather.api.HostType;
import lol.ye0yeg.lolweather.bean.WeatherData;
import lol.ye0yeg.lolweather.bean.WeatherXml;
import lol.ye0yeg.lolweather.ui.baserx.RxSchedulers;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by ye0ye on 2017/6/22.
 */
public class WeatherModel implements WeatherDataContract.Model {

    @Override
    public Observable<WeatherData> getWeatherDataList(String city, String password, String day) {
        return Api.getDefault(HostType.MY_WEATHER, 1).
                getWData(Api.getCacheControl(), city, password, day).
                flatMap(new Func1<WeatherXml, Observable<WeatherData>>() {
                    @Override
                    public Observable<WeatherData> call(WeatherXml weatherXml) {
                        return Observable.from(weatherXml.getList());
                    }
                }).compose(RxSchedulers.<WeatherData>io_main());
    }
}
