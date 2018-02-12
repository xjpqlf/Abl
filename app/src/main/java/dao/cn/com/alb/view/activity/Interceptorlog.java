package dao.cn.com.alb.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;
import dao.cn.com.alb.R;
import dao.cn.com.alb.view.adapter.CusromerPagerAdapter;

/**
 * @name dao.cn.com.alb.view.activity
 * @class name：Alb
 * @class describe
 * @anthor uway QQ:343251588
 * @time 2018/2/10 22:50
 * @change uway
 * @chang 2018/2/10 22:50
 * @class describe
 */


public class Interceptorlog extends FragmentActivity {
    @Bind(R.id.tl_message)
    TabLayout mTabLayout;
    @Bind(R.id.vp_message)
    ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
       //给tablayout设置适配器
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        //通过构造函数new adapter
        CusromerPagerAdapter adapter = new CusromerPagerAdapter(getSupportFragmentManager(), Interceptorlog.this);
        mViewPager.setAdapter(adapter);
        //结合viewppager
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(adapter);
    }


}
