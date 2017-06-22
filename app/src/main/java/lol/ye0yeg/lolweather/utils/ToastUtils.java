package lol.ye0yeg.lolweather.utils;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import lol.ye0yeg.lolweather.BaseApplication;
import lol.ye0yeg.lolweather.R;

/**
 * Created by Administrator on 6/22/2017.
 */

public class ToastUtils {
    private static Toast toast_1;
    private static Toast toast_2;

    private static Toast createToast(CharSequence msg, int duration) {
        if (toast_1 == null) {
            toast_1 = Toast.makeText(BaseApplication.mContext, msg, duration);
        } else {
            toast_1.setText(msg);
            toast_1.setDuration(duration);
        }
        return toast_1;
    }

    public static void showShort(CharSequence msg) {
        createToast(msg, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(int strId) {
        createToast(BaseApplication.getAppResources().getText(strId), Toast.LENGTH_SHORT).show();
    }

    public static void showLong(CharSequence msg) {
        createToast(msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(int strId) {
        createToast(BaseApplication.getAppResources().getText(strId), Toast.LENGTH_SHORT).show();
    }

    /*
    * 带图土司
    * */
    public static Toast showToastWithImg(final String tvStr, final int imageResource) {
        if (toast_2 == null) {
            toast_2 = new Toast(BaseApplication.mContext);
        }
        View view = LayoutInflater.from(BaseApplication.mContext).inflate(R.layout.toast_custom, null);
        TextView tv = (TextView) view.findViewById(R.id.toast_custom_tv);
        tv.setText(TextUtils.isEmpty(tvStr) ? "" : tvStr);
        ImageView iv = (ImageView) view.findViewById(R.id.toast_custom_iv);
        if (imageResource > 0) {
            iv.setVisibility(View.VISIBLE);
            iv.setImageResource(imageResource);
        } else {
            iv.setVisibility(View.GONE);
        }
        toast_2.setView(view);
        toast_2.setGravity(Gravity.CENTER, 0, 0);
        toast_2.show();
        return toast_2;

    }

}
