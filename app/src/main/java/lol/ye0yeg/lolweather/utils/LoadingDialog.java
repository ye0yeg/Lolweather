package lol.ye0yeg.lolweather.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import lol.ye0yeg.lolweather.R;

/**
 * Created by Administrator on 6/22/2017.
 */

public class LoadingDialog {
    private static Dialog mLoadingDialog;

    //制作自定义LoadingDialog！！
    public static Dialog showDialogForLoading(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        TextView tv_loading = view.findViewById(R.id.id_tv_loading_dialog_text);
        tv_loading.setText("Loading...");
        mLoadingDialog = new Dialog(context, R.style.CustomProgressDialog);
        mLoadingDialog.setCancelable(true);
        mLoadingDialog.setCanceledOnTouchOutside(true);
        mLoadingDialog.setContentView(view,
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                ));
        mLoadingDialog.show();
        return mLoadingDialog;
    }

    public static Dialog showDialogForLoading(Context context,String str, boolean cancleable){
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading,null);
        TextView tv_loading = view.findViewById(R.id.id_tv_loading_dialog_text);
        tv_loading.setText(str);
        mLoadingDialog = new Dialog(context, R.style.CustomProgressDialog);
        mLoadingDialog.setCancelable(cancleable);
        mLoadingDialog.setCanceledOnTouchOutside(false);
        mLoadingDialog.setContentView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        mLoadingDialog.show();
        return mLoadingDialog;
    }

    public static void cancelDialogForLoading() {
        if (mLoadingDialog != null) {
            mLoadingDialog.cancel();
        }
    }
}
