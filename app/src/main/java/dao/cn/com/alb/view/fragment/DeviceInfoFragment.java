package dao.cn.com.alb.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dao.cn.com.alb.R;

/**
 * @name dao.cn.com.alb.view.fragment
 * @class name：Alb
 * @class describe
 * @anthor uway QQ:343251588
 * @time 2018/2/10 23:11
 * @change uway
 * @chang 2018/2/10 23:11
 * @class describe
 */


public class DeviceInfoFragment extends BaseFragment{

    public static DeviceInfoFragment newInstance() {
        DeviceInfoFragment fragment = new DeviceInfoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.device, container, false);
        return view;
    }
}
