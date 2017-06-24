package lol.ye0yeg.lolweather.ui.base;

/**
 * Created by Administrator on 6/23/2017.
 */
public interface BaseView {
    
    void showLoading(String title);

    void stopLoading();

    void showErrorTip(int msg);

    void showErrorTip(String msg);
}
