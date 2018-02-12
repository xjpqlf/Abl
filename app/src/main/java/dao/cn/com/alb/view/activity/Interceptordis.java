package dao.cn.com.alb.view.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.fastjson.JSON;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import dao.cn.com.alb.R;
import dao.cn.com.alb.view.Constants;
import dao.cn.com.alb.view.bean.Logs;
import dao.cn.com.alb.view.bean.MyPieData;
import dao.cn.com.alb.view.utils.DebugFlags;
import dao.cn.com.alb.view.utils.SharedPrefUtil;
import okhttp3.Call;
import okhttp3.MediaType;

/**
 * @name dao.cn.com.alb.view.activity
 * @class name：Alb
 * @class describe
 * @anthor uway QQ:343251588
 * @time 2018/2/10 19:07
 * @change uway
 * @chang 2018/2/10 19:07
 * @class describe
 */


public class Interceptordis extends Activity {

    private  PieChart mPieChart ;
    private List<MyPieData> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ljfb);
        init();
    }

    private void init() {

        //饼状图
        mPieChart = (PieChart) findViewById(R.id.mPieChart);
        mPieChart.setUsePercentValues(true);
        mPieChart.getDescription().setEnabled(false);
        mPieChart.setExtraOffsets(5, 10, 5, 5);
        mPieChart.setDragDecelerationFrictionCoef(0.95f);
        //设置中间文件
      //  mPieChart.setCenterText(generateCenterSpannableText());

        mPieChart.setDrawHoleEnabled(true);
        mPieChart.setHoleColor(Color.WHITE);

        mPieChart.setTransparentCircleColor(Color.WHITE);
        mPieChart.setTransparentCircleAlpha(110);

        mPieChart.setHoleRadius(0);
        mPieChart.setTransparentCircleRadius(0);

        mPieChart.setDrawCenterText(true);

        mPieChart.setRotationAngle(0);
        // 触摸旋转
        mPieChart.setRotationEnabled(false);
        mPieChart.setHighlightPerTapEnabled(false);
        getData();


        mPieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);

        Legend l = mPieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(5f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // 输入标签样式
        mPieChart.setEntryLabelColor(Color.WHITE);
        mPieChart.setEntryLabelTextSize(10f);








    }



    //设置数据
    private void setData(ArrayList<PieEntry> entries) {
        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        //数据和颜色
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        //颜色填充
        dataSet.setColors(new int[]{Color.rgb(145, 200, 175), Color.rgb(196, 59, 41), Color.rgb(46,69, 83), Color.rgb(97, 160, 169), Color.rgb(211, 129, 99)});
       /* dataSet.setValueLinePart1OffsetPercentage(100f);
        dataSet.setValueLinePart1Length(0.6f);
        dataSet.setValueLinePart2Length(0.2f);
        dataSet.setHighlightEnabled(true);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);//标签显示在外面，关闭显示在饼图里面

        dataSet.setValueLineColor(0xff000000); //设置指示线条颜色,必须设置成这样，才能和饼图区域颜色一致*/

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(8f);
        data.setValueTextColor(Color.WHITE);
        mPieChart.setData(data);
        mPieChart.highlightValues(null);
        //刷新
        mPieChart.invalidate();
    }


private void   getData(){

    String comanyId= SharedPrefUtil.getString(Interceptordis.this,"sid","");
    OkHttpUtils.postString()
            .url(Constants.BASE_URL+"/home/get_countUrl")
            .addHeader("sid",SharedPrefUtil.getString(Interceptordis.this,"sid",""))
            .mediaType(MediaType.parse("application/json; charset=utf-8")) //设置post的字符串为json字符串并设置编码 .content(new Gson().toJson(new User("zhy", "123"))) //用Gson将User对象转化为Json字符串的形式作为content .build() .execute(new MyStringCallback());
            .content(new Gson().toJson(new Logs(SharedPrefUtil.getString(Interceptordis.this,"companyId",""))))
            .build()
            .execute(new MyStringCallback());







    }

    public class MyStringCallback extends StringCallback {
        //MyStringCallback用于向json server处理有关字符串的请求（Json/Http/Https 字符串callback）
        @Override
        public void onError(Call call, Exception e, int id) {
            e.printStackTrace();
        }

        @Override
        public void onResponse(String response, int id) {

            DebugFlags.logD("饼子"+response);
            try {
                JSONObject json=new JSONObject(response);
                String data=json.getString("data");
                mList = JSON.parseArray(data,MyPieData.class);

                //模拟数据
                ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
                for (int i=0;i<mList.size();i++){
                    entries.add(new PieEntry(Float.parseFloat(mList.get(i).getDocCount()),mList.get(i).getEnilType()));

                }


                //设置数据
                setData(entries);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }
}
