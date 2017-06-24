package lol.ye0yeg.lolweather.ui.presenter;

import android.content.Context;

import lol.ye0yeg.lolweather.bean.WeatherData;
import lol.ye0yeg.lolweather.ui.model.WeatherDataContract;
import lol.ye0yeg.lolweather.utils.LoadingDialog;
import rx.Subscriber;

/**
 * Created by ye0ye on 2017/6/22.
 */
public class WeatherPresenter extends WeatherDataContract.Presenter {
    private Context mContext;
    @Override
    public void requestWeatherData(String city, String password, final String day) {
        mModel.getWeatherDataList(city, password, day).
                subscribe(new Subscriber<WeatherData>() {
                    @Override
                    public void onStart() {
                        LoadingDialog.showDialogForLoading(mContext);
                    }

                    @Override
                    public void onCompleted() {
                        LoadingDialog.cancelDialogForLoading();

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showErrorTip(e.toString());
                    }

                    @Override
                    public void onNext(WeatherData weatherData) {
                        mView.returnWeatherXmlData(weatherData,day);
                    }
                });
    }
}
