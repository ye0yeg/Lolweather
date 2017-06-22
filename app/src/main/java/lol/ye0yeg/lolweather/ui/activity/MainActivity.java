package lol.ye0yeg.lolweather.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import butterknife.BindView;
import lol.ye0yeg.lolweather.R;
import lol.ye0yeg.lolweather.ui.base.BaseActivity;
import lol.ye0yeg.lolweather.ui.fragment.LeftSlideFragment;
import lol.ye0yeg.lolweather.ui.fragment.WeatherFragment;

public class MainActivity extends BaseActivity implements LeftSlideFragment.OnCloseDrawerLayout {
    @BindView(R.id.main_foot_rg)
    RadioGroup rg_main_foot_rg;
    @BindView(R.id.drawerlayout)
    DrawerLayout dl_drawerlayout;
    @BindView(R.id.fl_main_frame)
    FrameLayout fl_main_frame;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        WeatherFragment weatherFragment = new WeatherFragment();

    }

    @Override
    public void OnClose() {

    }
}
