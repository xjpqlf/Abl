package dao.cn.com.alb.view;

import android.app.Application;
import android.content.Context;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * @name dao.cn.com.alb.view
 * @class name：Alb
 * @class describe
 * @anthor uway QQ:343251588
 * @time 2018/2/9 10:23
 * @change uway
 * @chang 2018/2/9 10:23
 * @class describe
 */


public class Ablapplication extends Application {
    private static Ablapplication instance;

    public static Context context = null;

    public Ablapplication(){instance = this;}
    public static Ablapplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }



    public static Context getAppContext() {
        return context;
    }



    private void init(){
//        initLocationService();





        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(20000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);





    }

}
