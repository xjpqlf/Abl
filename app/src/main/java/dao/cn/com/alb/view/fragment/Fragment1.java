package dao.cn.com.alb.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dao.cn.com.alb.R;
import dao.cn.com.alb.view.activity.FlowtrendActivity;
import dao.cn.com.alb.view.activity.Interceptordis;
import dao.cn.com.alb.view.activity.Interceptorlog;

/**
 * Created by chenzhe on 2018/2/8.
 */

public class Fragment1 extends BaseFragment {

    @Bind(R.id.rl_ljfb)
    RelativeLayout rlLjfb;
    @Bind(R.id.rl_ljph)
    RelativeLayout rlLjph;
    @Bind(R.id.rl_llqs)
    RelativeLayout rlLlqs;
    @Bind(R.id.rl_ljrz)
    RelativeLayout rlLjrz;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.rl_ljfb, R.id.rl_ljph, R.id.rl_llqs, R.id.rl_ljrz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_ljfb:
                startActivity(new Intent(getActivity(), Interceptordis.class));
                break;
            case R.id.rl_ljph:
                startActivity(new Intent(getActivity(), Interceptordis.class));
                break;
            case R.id.rl_llqs:
                startActivity(new Intent(getActivity(), FlowtrendActivity.class));
                break;
            case R.id.rl_ljrz:
                startActivity(new Intent(getActivity(), Interceptorlog.class));
                break;
        }
    }
}
