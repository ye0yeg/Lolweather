package lol.ye0yeg.lolweather.ui.base;

import android.content.Context;

/**
 * Created by Administrator on 6/22/2017.
 *
 * 桥梁，绑定 Model 和 View
 */
public class BasePresenter<T, E> {
    public Context mContext;
    public E mModel;
    public T mView;

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
    }
}
