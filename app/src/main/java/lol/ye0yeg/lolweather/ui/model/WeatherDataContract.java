package lol.ye0yeg.lolweather.ui.model;

import lol.ye0yeg.lolweather.bean.WeatherData;
import lol.ye0yeg.lolweather.ui.base.BaseModel;
import lol.ye0yeg.lolweather.ui.base.BasePresenter;
import lol.ye0yeg.lolweather.ui.base.BaseView;
import rx.Observable;

/**
 * Created by ye0ye on 2017/6/22.
 * 沟通层
 * <p>
 * 可恶的沟通层, 实现接口到类的变化
 */
public interface WeatherDataContract {


    interface Model extends BaseModel {
        Observable<WeatherData> getWeatherDataList(String city, String password, String day);
    }

    interface View extends BaseView {
        void returnWeatherXmlData(WeatherData weatherData, String day);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void requestWeatherData(String city, String password, String day);
    }
}
