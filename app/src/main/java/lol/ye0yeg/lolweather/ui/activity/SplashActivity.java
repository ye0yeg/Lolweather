package lol.ye0yeg.lolweather.ui.activity;

import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import butterknife.BindView;
import lol.ye0yeg.lolweather.R;
import lol.ye0yeg.lolweather.ui.base.BaseActivity;

/**
 * Created by Administrator on 6/22/2017.
 */

public class SplashActivity extends BaseActivity {
    @BindView(R.id.launch_iv)
    ImageView iv_splash;


    private boolean isDownLoad;
    private RequestManager requestManager;

    @Override
    protected int setLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        iv_splash = (ImageView) findViewById(R.id.launch_iv);
        requestManager = Glide.with(getApplicationContext());
        //广告加载
        initAd();
        launchAnim(iv_splash);

    }


    private void launchAnim(ImageView iv_splash) {

        Animation anim = new ScaleAnimation(1, 1.2f, 1, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(2000);
        anim.setFillAfter(true);
        iv_splash.startAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                startLoadingDialog("停止！！");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                stopLoadingDialog();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void initAd() {

    }
}
