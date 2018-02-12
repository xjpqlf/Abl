package dao.cn.com.alb.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import dao.cn.com.alb.R;
import dao.cn.com.alb.view.adapter.MyAdapter;
import dao.cn.com.alb.view.fragment.BaseFragment;
import dao.cn.com.alb.view.fragment.Fragment1;
import dao.cn.com.alb.view.fragment.Fragment2;
import dao.cn.com.alb.view.fragment.Fragment3;
import dao.cn.com.alb.view.fragment.Fragment4;
import dao.cn.com.alb.view.fragment.Fragment5;
import dao.cn.com.alb.view.view.NoScrollViewPager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<BaseFragment> mFragment = new ArrayList<>();

    private LinearLayout ll_tab;

    private NoScrollViewPager viewPager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll_tab = (LinearLayout) findViewById(R.id.ll_tab);
         viewPager = (NoScrollViewPager) findViewById(R.id.viewPager);
        viewPager.setScanScroll(false);
        ll_tab.getChildAt(0).setSelected(true);

        mFragment.add(new Fragment1());
        mFragment.add(new Fragment2());
        mFragment.add(new Fragment3());
        mFragment.add(new Fragment4());
        mFragment.add(new Fragment5());

        FragmentManager fragmentManager = getSupportFragmentManager();
        MyAdapter myAdapter = new MyAdapter(fragmentManager);
        myAdapter.setFragments(mFragment);
        // viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(myAdapter);
        //  viewPager.setCurrentItem(0);
        for (int i = 0; i < ll_tab.getChildCount(); i++) {
            ll_tab.getChildAt(i).setTag(i);
            ll_tab.getChildAt(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        resetChoose();
        int tag = (int) v.getTag();
        ll_tab.getChildAt(tag).setSelected(true);
        viewPager.setCurrentItem(tag,false);
    }

    private void resetChoose() {
        for (int i = 0; i < ll_tab.getChildCount(); i++) {
            ll_tab.getChildAt(i).setSelected(false);
        }
    }

}
