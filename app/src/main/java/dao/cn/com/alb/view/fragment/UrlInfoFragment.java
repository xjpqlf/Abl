package dao.cn.com.alb.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.ButterKnife;
import dao.cn.com.alb.R;
import dao.cn.com.alb.view.Constants;
import dao.cn.com.alb.view.adapter.UrlAdapter;
import dao.cn.com.alb.view.bean.Logs;
import dao.cn.com.alb.view.bean.LogsDetail;
import dao.cn.com.alb.view.utils.SharedPrefUtil;
import okhttp3.Call;
import okhttp3.MediaType;

import static dao.cn.com.alb.R.id.lv;

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


public class UrlInfoFragment extends BaseFragment {


    private ListView mLv;

    public static UrlInfoFragment newInstance() {
        UrlInfoFragment fragment = new UrlInfoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.device, container, false);
        mLv = (ListView) view.findViewById(lv);
        init();

        return view;
    }

    private void init() {
       /* List<Infos> list = new ArrayList<>();
        Infos infos1 = new Infos("1", "2018-2-2 19;22;22", "黑名单", "www.baiddu.com");
        Infos infos2 = new Infos("1", "2018-2-2 19;22;22", "黑名单", "www.baiddu.com");
        Infos infos3 = new Infos("1", "2018-2-2 19;22;22", "黑名单", "www.baiddu.com");

        list.add(infos1);
        list.add(infos2);
        list.add(infos3);
        UrlAdapter adapter=new UrlAdapter(getActivity(),list);
        mLv.setAdapter(adapter);*/

 /*      .ALL:""//可忽略
                .companyId:10012
                sid
                .pageNo:1//当前页码
                .pageSize:10//当前条数
                .url:""//可忽略*/
 String comanyId=SharedPrefUtil.getString(getActivity(),"sid","");
        OkHttpUtils .postString()
                .url(Constants.BASE_URL+"/log/findInterceptInfoWithPage")
                .addHeader("sid",SharedPrefUtil.getString(getActivity(),"sid",""))
                .mediaType(MediaType.parse("application/json; charset=utf-8")) //设置post的字符串为json字符串并设置编码 .content(new Gson().toJson(new User("zhy", "123"))) //用Gson将User对象转化为Json字符串的形式作为content .build() .execute(new MyStringCallback());
                .content(new Gson().toJson(new Logs("","comanyId","1","10","")))
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

            try {
                JSONObject json=new JSONObject(response);
                 String code=json.getString("code");
                if ("200".equals(code)){
                    String data=json.getString("data");
                    JSONObject json1=new JSONObject(data);
                     String deta=  json1.getString("details");

                    List<LogsDetail> list= JSON.parseArray(deta, LogsDetail.class);

                    UrlAdapter adapter=new UrlAdapter(getActivity(),list);
                    mLv.setAdapter(adapter);

                }



            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
