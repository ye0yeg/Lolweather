package lol.ye0yeg.lolweather.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import lol.ye0yeg.lolweather.R;
import lol.ye0yeg.lolweather.bean.PicBean;

/**
 * Created by Administrator on 6/24/2017.
 */
public class PicRecyclerAdapter extends BaseQuickAdapter<PicBean,BaseViewHolder>{

    public PicRecyclerAdapter() {
        super(R.layout.item_picfrag);
    }

    @Override
    protected void convert(BaseViewHolder helper, PicBean bean) {
        Glide.with(mContext)
                .load(bean.getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .crossFade()
                .centerCrop()
                .into((ImageView) helper.getView(R.id.iv_picfrag));
    }
}
