package lol.ye0yeg.lolweather.ui.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import butterknife.ButterKnife;
import lol.ye0yeg.lolweather.AppManager;
import lol.ye0yeg.lolweather.utils.LoadingDialog;
import lol.ye0yeg.lolweather.utils.TUtils;
import lol.ye0yeg.lolweather.utils.ToastUtils;

/**
 * Created by Administrator on 6/22/2017.
 */
public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity {
    public T mPresenter;
    public E mModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBefore();
        setContentView(setLayout());
        //推送
        //注入
        ButterKnife.bind(this);
        mPresenter = TUtils.getT(this, 0);
        mModel = TUtils.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }
        initPresenter();
        initView();

    }

    private void doBefore() {
        //主题设置
        AppManager.newInstance().addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    /**
     * 跳转界面
     *
     * @param clazz
     */
    public void startActivity(Class<?> clazz) {
        startActivity(clazz, null);
    }

    /**
     * 含bundle跳转界面
     *
     * @param clazz
     * @param bundle
     */
    public void startActivity(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    //View 接口实现部分，这没有 IBaseView , 假如有 ，实现接口
    /*
    * 开始加载窗口
    * */
    public void startLoadingDialog() {
        LoadingDialog.showDialogForLoading(this);
    }

    /*
    * 加载with word
    * */
    public void startLoadingDialog(String str) {
        LoadingDialog.showDialogForLoading(this, str, false);
    }

    /*
    * 停止加载窗口
    * */
    public void stopLoadingDialog() {
        LoadingDialog.cancelDialogForLoading();
    }

    /*
    * 土司
    * */
    public void showShortToast(String str) {
        ToastUtils.showShort(str);
    }

    /*
* 土司
* */
    public void showShortToast(int strId) {
        ToastUtils.showShort(strId);
    }

    /*
    * 长土司
    * */
    public void showLongToast(int strId) {
        ToastUtils.showLong(strId);
    }

    /*
    * Long土司
    * */
    public void showLongToast(String str) {
        ToastUtils.showLong(str);
    }

    /*
    * 图片土司
    * */
    public void showImgToast(String msg, int imgID) {
        ToastUtils.showToastWithImg(msg, imgID);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.newInstance().removeActivity(this);
    }

    protected abstract int setLayout();

    protected abstract void initPresenter();

    protected abstract void initView();


}
