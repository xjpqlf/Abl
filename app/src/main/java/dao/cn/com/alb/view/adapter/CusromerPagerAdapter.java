package dao.cn.com.alb.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;

import java.util.List;

import dao.cn.com.alb.view.fragment.DeviceInfoFragment;
import dao.cn.com.alb.view.fragment.UrlInfoFragment;

/**
 * Created by liuhuan-mac on 16/6/7.
 */
public class CusromerPagerAdapter extends FragmentPagerAdapter {

    private UrlInfoFragment qustionFragment;
    private DeviceInfoFragment myQustion;
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"网址信息", "设备信息"};
   /* private int[] imageResId = {R.drawable.qustions,
            R.drawable.advice,
            };*/
    private List<String> titleList;
    private Context context;
    public CusromerPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                if(qustionFragment == null){
                    qustionFragment = UrlInfoFragment.newInstance();
                }
                return qustionFragment;
            case 1:

                    if (myQustion == null) {
                        myQustion = myQustion.newInstance();
                    }
                    return myQustion;


        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
     //   Drawable image = context.getResources().getDrawable(imageResId[position]);
     //   image.setBounds(0, 0, 50, 50);

        // Replace blank spaces with image icon
        SpannableString sb = new SpannableString("   " + tabTitles[position]);
      //  ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
      //  sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
}
