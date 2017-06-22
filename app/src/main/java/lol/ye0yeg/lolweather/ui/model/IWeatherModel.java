package lol.ye0yeg.lolweather.ui.model;

import lol.ye0yeg.lolweather.ui.base.BaseModel;
import rx.Observable;

/**
 * Created by ye0ye on 2017/6/22.
 */
public interface IWeatherModel {
    interface Model extends BaseModel{
        Observable<WeatherData>

    }
}
