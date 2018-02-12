package dao.cn.com.alb.view.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;

import dao.cn.com.alb.R;
import dao.cn.com.alb.view.Constants;
import dao.cn.com.alb.view.bean.Logs;
import dao.cn.com.alb.view.utils.DebugFlags;
import dao.cn.com.alb.view.utils.SharedPrefUtil;
import okhttp3.Call;
import okhttp3.MediaType;

/**
 * @name dao.cn.com.alb.view.activity
 * @class name：Alb
 * @class describe
 * @anthor uway QQ:343251588
 * @time 2018/2/10 21:40
 * @change uway
 * @chang 2018/2/10 21:40
 * @class describe
 */


public class FlowtrendActivity extends Activity {

    private HorizontalBarChart mHorizontalBarChart;
    private ArrayList  yAxisValues1;
    private ArrayList   yAxisValues2;
    private ArrayList xAxisValues;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
        init();
        initdata();
    }

    private void initdata() {

            xAxisValues = new ArrayList<>();
            yAxisValues1 = new ArrayList<>();
            yAxisValues2 = new ArrayList<>();
            for(int i=0;i<10;++i){
                xAxisValues.add(i);
                yAxisValues1.add((float)(Math.random()*30+20));
                yAxisValues2.add((float)(Math.random()*20+20));
            }

    }

    private void init() {
        getData();
        mHorizontalBarChart = (HorizontalBarChart) findViewById(R.id.mHorizontalBarChart);

        //设置相关属性
       // mHorizontalBarChart.setOnChartValueSelectedListener(this);
        mHorizontalBarChart.setDrawBarShadow(false);
      //  mHorizontalBarChart.setDrawValueAboveBar(true);
        mHorizontalBarChart.getDescription().setEnabled(false);
        mHorizontalBarChart.setMaxVisibleValueCount(60);
        mHorizontalBarChart.setPinchZoom(false);
        mHorizontalBarChart.setDrawGridBackground(false);
        mHorizontalBarChart.setTouchEnabled(false);


        //x轴
        XAxis xl = mHorizontalBarChart.getXAxis();
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);

        xl.setDrawAxisLine(true);
        xl.setDrawGridLines(false);
        xl.setGranularity(10f);

        //y轴
        YAxis yl = mHorizontalBarChart.getAxisLeft();
        yl.setDrawAxisLine(true);
        yl.setDrawGridLines(true);
        yl.setAxisMinimum(0f);

        //y轴
        YAxis yr = mHorizontalBarChart.getAxisRight();
        yr.setDrawAxisLine(true);
        yr.setDrawGridLines(false);
        yr.setAxisMinimum(0f);

        //设置数据
       setData(12, 50);

        mHorizontalBarChart.setFitBars(true);
        mHorizontalBarChart.animateY(2500);

        Legend l = mHorizontalBarChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setFormSize(8f);
        l.setXEntrySpace(4f);












    }


    //来点随机数吧
    private void setData(int count, float range) {
        float barWidth = 6f;
        float spaceForBar = 10f;
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();
        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range);
            yVals1.add(new BarEntry(i * spaceForBar, val));
        }

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() *range);
            yVals2.add(new BarEntry(i * spaceForBar, val));
        }


        BarDataSet set1;
        BarDataSet set2;
        if (mHorizontalBarChart.getData() != null &&
                mHorizontalBarChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mHorizontalBarChart.getData().getDataSetByIndex(0);
            set2 = (BarDataSet) mHorizontalBarChart.getData().getDataSetByIndex(1);
            set1.setValues(yVals1);
            set2.setValues(yVals2);

            set1.setDrawValues(false);

            set2.setDrawValues(false);

            mHorizontalBarChart.getData().notifyDataChanged();
            mHorizontalBarChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "上行");
            set2=new BarDataSet(yVals2, "下载");
           set1.setColor(Color.rgb(129, 216, 200));
            set2.setColor(Color.rgb(181, 194, 202));
            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);
            dataSets.add(set2);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(barWidth);
            mHorizontalBarChart.setData(data);
        }
    }

    private void   getData(){

        String comanyId= SharedPrefUtil.getString(FlowtrendActivity.this,"sid","");
        OkHttpUtils.postString()
                .url(Constants.BASE_URL+"/home/get_flow")
                .addHeader("sid",SharedPrefUtil.getString(FlowtrendActivity.this,"sid",""))
                .mediaType(MediaType.parse("application/json; charset=utf-8")) //设置post的字符串为json字符串并设置编码 .content(new Gson().toJson(new User("zhy", "123"))) //用Gson将User对象转化为Json字符串的形式作为content .build() .execute(new MyStringCallback());
                .content(new Gson().toJson(new Logs(SharedPrefUtil.getString(FlowtrendActivity.this,"companyId",""),"day")))
                .build()
                .execute(new MyStringCallback());







    }

}
class MyStringCallback extends StringCallback {
    //MyStringCallback用于向json server处理有关字符串的请求（Json/Http/Https 字符串callback）
    @Override
    public void onError(Call call, Exception e, int id) {
        e.printStackTrace();
    }

    @Override
    public void onResponse(String response, int id) {

        DebugFlags.logD("流量"+response);


    }

}