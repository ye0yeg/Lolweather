package lol.ye0yeg.lolweather.ui.fragment;

import lol.ye0yeg.lolweather.R;
import lol.ye0yeg.lolweather.bean.WeatherData;
import lol.ye0yeg.lolweather.ui.base.BaseFragment;
import lol.ye0yeg.lolweather.ui.model.WeatherDataContract;
import lol.ye0yeg.lolweather.ui.model.WeatherModel;
import lol.ye0yeg.lolweather.ui.presenter.WeatherPresenter;

/**
 * Created by ye0ye on 2017/6/22.
 */
public class WeatherFragment extends BaseFragment<WeatherPresenter, WeatherModel> implements WeatherDataContract.View{

    @Override
    protected int setLayout() {
        return R.layout.frag_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);

    }

    @Override
    protected void initView() {

    }

    /*
    * View 中的方法
    * */
    @Override
    public void returnWeatherXmlData(WeatherData weatherData, String day) {

    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(int msg) {

    }

    @Override
    public void showErrorTip(String msg) {

    }
}
