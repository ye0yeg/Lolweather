package lol.ye0yeg.lolweather.ui.fragment;

import butterknife.BindView;
import lol.ye0yeg.lolweather.R;
import lol.ye0yeg.lolweather.ui.activity.MainActivity;
import lol.ye0yeg.lolweather.ui.base.BaseFragment;

/**
 * Created by ye0ye on 2017/6/22.
 */
public class LeftSlideFragment extends BaseFragment {


    private MainActivity mainActivity;

    @Override
    protected int setLayout() {
        return R.layout.frag_leftslide_layout;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        mainActivity = (MainActivity) getActivity();

    }

    public interface OnCloseDrawerLayout {
        void OnClose();
    }

    public void setOnCloseDrawerLayout(OnCloseDrawerLayout onCloseDrawerLayout){
        onCloseDrawerLayout.OnClose();
    }
}
