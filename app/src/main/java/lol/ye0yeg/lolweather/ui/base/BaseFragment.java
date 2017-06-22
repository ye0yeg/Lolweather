package lol.ye0yeg.lolweather.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import lol.ye0yeg.lolweather.utils.LoadingDialog;
import lol.ye0yeg.lolweather.utils.TUtils;
import lol.ye0yeg.lolweather.utils.ToastUtils;

/**
 * Created by ye0ye on 2017/6/22.
 */
public abstract class BaseFragment<T extends BasePresenter, E extends BaseModel> extends Fragment {
    public T mPresenter;
    public E mBaseModel;
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(setLayout(), container, false);
        }
        ButterKnife.bind(this, mRootView);
        mPresenter = TUtils.getT(this, 0);
        mBaseModel = TUtils.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
        }
        initPresenter();
        initView();
        return mRootView;
    }

    public void startLoadingDialog() {
        LoadingDialog.showDialogForLoading(getActivity());
    }

    public void startLoadingDialog(String str) {
        LoadingDialog.showDialogForLoading(getActivity(), str, false);
    }

    public void stopLoadingDialog() {
        LoadingDialog.cancelDialogForLoading();
    }

    public void showShortToast(String msg) {
        ToastUtils.showShort(msg);
    }

    public void showShortToast(int strId) {
        ToastUtils.showShort(strId);
    }

    public void showLongToast(String msg) {
        ToastUtils.showShort(msg);
    }

    public void showLongToast(int strId) {
        ToastUtils.showShort(strId);
    }

    public void showImgToast(String msg, int imgId) {
        ToastUtils.showToastWithImg(msg, imgId);
    }


    protected abstract int setLayout();

    public abstract void initPresenter();

    protected abstract void initView();
}