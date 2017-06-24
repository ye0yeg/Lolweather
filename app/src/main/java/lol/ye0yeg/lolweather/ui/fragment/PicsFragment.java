package lol.ye0yeg.lolweather.ui.fragment;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.wilddog.client.DataSnapshot;
import com.wilddog.client.SyncError;
import com.wilddog.client.SyncReference;
import com.wilddog.client.ValueEventListener;
import com.wilddog.client.WilddogSync;
import com.wilddog.wilddogcore.WilddogApp;
import com.wilddog.wilddogcore.WilddogOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import lol.ye0yeg.lolweather.BaseApplication;
import lol.ye0yeg.lolweather.R;
import lol.ye0yeg.lolweather.adapter.PicRecyclerAdapter;
import lol.ye0yeg.lolweather.bean.PicBean;
import lol.ye0yeg.lolweather.ui.base.BaseFragment;
import lol.ye0yeg.lolweather.utils.StringUtils;

/**
 * Created by Administrator on 6/24/2017.
 */

public class PicsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.pic_swipe)
    SwipeRefreshLayout pic_swipe;
    @BindView(R.id.pic_recycle)
    RecyclerView pic_recycle;
    @BindView(R.id.toolBar)
    Toolbar mToolBar;

    private List<PicBean> picList;
    private List<PicBean> picNowList;

    private SyncReference mRef;
    private GridLayoutManager gridLayoutManager;
    private PicRecyclerAdapter picRecyclerAdapter;

    private boolean isInit = true;

    @Override
    protected int setLayout() {
        return R.layout.frag_pic;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        initWildDog();
        initPic();
        initRecycleEvent();

    }

    private void initWildDog() {
        WilddogOptions mWilddogOptions = new WilddogOptions.Builder().setSyncUrl("https://xandone-weather.wilddogio.com").build();
        WilddogApp.initializeApp(BaseApplication.mContext, mWilddogOptions);
        mRef = WilddogSync.getInstance().getReference();
    }


    private void initPic() {
        mToolBar.setTitle("MeiZi");
        picList = new ArrayList<>();
        picNowList = new ArrayList<>();

        pic_swipe.setColorSchemeColors(Color.RED, Color.GREEN);
        pic_swipe.setOnRefreshListener(this);

        gridLayoutManager = new GridLayoutManager(BaseApplication.mContext, 2);
        picRecyclerAdapter = new PicRecyclerAdapter();
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position == picRecyclerAdapter.getItemCount() - 1) ? gridLayoutManager.getSpanCount() : 1;
            }
        });
        pic_recycle.setLayoutManager(gridLayoutManager);
        pic_recycle.setAdapter(picRecyclerAdapter);
        getDataFromWdot(mRef);
    }

    private void getDataFromWdot(SyncReference ref) {
        if (ref == null) {
            return;
        }
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Object> value = (Map<String, Object>) dataSnapshot.getValue();
                List<Object> list = (List<Object>) value.get("results");
                picList.clear();
                for (Object obj : list) {
                    Map<String, String> o = (Map<String, String>) obj;
                    if (!StringUtils.isEmpty(o.get("url"))) {
                        picList.add(new PicBean(o.get("url")));
                    }
                }
                if (isInit) {
                    for (int i = 0; i < 12; i++) {
                        picNowList.add(picList.get(i));
                    }
                    isInit = false;
                }
                picRecyclerAdapter.notifyDataSetChanged();
                stopLoadingDialog();
            }


            @Override
            public void onCancelled(SyncError syncError) {

            }
        });
    }

    private void initRecycleEvent() {
    }


    @Override
    public void onRefresh() {
        getDataFromWdot(mRef);
    }

    /**
     * 关闭刷新
     */
    public void closeRefresh() {
        pic_swipe.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (pic_swipe != null) {
                    pic_swipe.setRefreshing(false);
                }
            }
        }, 1200);
    }
}
