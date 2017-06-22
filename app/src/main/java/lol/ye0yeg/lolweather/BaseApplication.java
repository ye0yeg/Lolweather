package lol.ye0yeg.lolweather;

import android.app.Application;
import android.content.res.Resources;

/**
 * Created by Administrator on 6/22/2017.
 */

public class BaseApplication extends Application{
    public static BaseApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        //极光推送 registUmengPush

    }

    public static Resources getAppResources() {
        return mContext.getResources();
    }
}
