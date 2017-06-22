package lol.ye0yeg.lolweather.ui.base;

import android.content.Context;

import lol.ye0yeg.lolweather.utils.LoadingDialog;
import lol.ye0yeg.lolweather.utils.ToastUtils;

/**
 * Created by ye0ye on 2017/6/22.
 */
public class BaseDialog {

    public static void startLoadingDialog(Context context) {
        LoadingDialog.showDialogForLoading(context);
    }

    public static void startLoadingDialog(Context context, String str) {
        LoadingDialog.showDialogForLoading(context, str, false);
    }

    public static void stopLoadingDialog() {
        LoadingDialog.cancelDialogForLoading();
    }

    public static void showShortToast(String msg) {
        ToastUtils.showShort(msg);
    }

    public static void showShortToast(int strId) {
        ToastUtils.showShort(strId);
    }

    public static void showLongToast(String msg) {
        ToastUtils.showShort(msg);
    }

    public static void showLongToast(int strId) {
        ToastUtils.showShort(strId);
    }

    public static void showImgToast(String msg, int imgId) {
        ToastUtils.showToastWithImg(msg, imgId);
    }

}
