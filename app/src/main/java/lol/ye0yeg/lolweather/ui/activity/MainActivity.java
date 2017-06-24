package lol.ye0yeg.lolweather.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import lol.ye0yeg.lolweather.R;
import lol.ye0yeg.lolweather.ui.base.BaseActivity;
import lol.ye0yeg.lolweather.ui.fragment.LeftSlideFragment;
import lol.ye0yeg.lolweather.ui.fragment.PicsFragment;
import lol.ye0yeg.lolweather.ui.fragment.WeatherFragment;

public class MainActivity extends BaseActivity implements LeftSlideFragment.OnCloseDrawerLayout {
    @BindView(R.id.main_foot_rg)
    RadioGroup rg_main_foot_rg;
    @BindView(R.id.drawerlayout)
    DrawerLayout dl_drawerlayout;
    @BindView(R.id.fl_main_frame)
    FrameLayout fl_main_frame;
    private List<Fragment> fragList;
    private int fragIndex;

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
        PicsFragment picsFragment = new PicsFragment();

        fragList = new ArrayList<Fragment>(Arrays.asList(new PicsFragment()));
        rg_main_foot_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.mian_footer_video_rb:
                        fragIndex = 0;
                        break;
                }
                turnToFrag();
            }
        });

        turnToFrag();

    }

    private void turnToFrag() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = fragList.get(fragIndex);
    }

    @Override
    public void OnClose() {

    }
}
