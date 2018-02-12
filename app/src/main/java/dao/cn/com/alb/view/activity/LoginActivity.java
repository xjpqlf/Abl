package dao.cn.com.alb.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dao.cn.com.alb.R;
import dao.cn.com.alb.view.Constants;
import dao.cn.com.alb.view.bean.User;
import dao.cn.com.alb.view.utils.DebugFlags;
import dao.cn.com.alb.view.utils.EncryptUtils;
import dao.cn.com.alb.view.utils.SharedPrefUtil;
import dao.cn.com.alb.view.utils.ToastUtil;
import okhttp3.Call;
import okhttp3.MediaType;

/**
 * @name dao.cn.com.alb.view
 * @class name：Alb
 * @class describe
 * @anthor uway QQ:343251588
 * @time 2018/2/8 18:44
 * @change uway
 * @chang 2018/2/8 18:44
 * @class describe
 */


public class LoginActivity extends Activity implements View.OnClickListener {

    @Bind(R.id.bt_login)
    RelativeLayout btLogin;
    @Bind(R.id.et_user)
    EditText etUser;
    @Bind(R.id.et_pwd)
    EditText etPwd;
    @Bind(R.id.et_yzm)
    EditText etYzm;
    @Bind(R.id.rl_yzm)
    RelativeLayout rlYzm;
    private ImageView iv_showCode;
    //产生的验证码
    private String realCode;
    private long mStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        iv_showCode = (ImageView) findViewById(R.id.iv_showCode);
        iv_showCode.setOnClickListener(this);

        //将验证码用图片的形式显示出来


        initView();
    }

    private void initView() {
        if (!TextUtils.isEmpty(SharedPrefUtil.getString(LoginActivity.this,"name",""))&&!TextUtils.isEmpty(SharedPrefUtil.getString(LoginActivity.this,"pwd",""))){

        etUser.setText(SharedPrefUtil.getString(LoginActivity.this,"name",""));
        etPwd.setText(SharedPrefUtil.getString(LoginActivity.this,"pwd",""));
        }


     setShowcode();


     isShowCode();




    }

    private void isShowCode() {


        OkHttpUtils.get()
                .url(Constants.BASE_URL + "/user/isDisplayValidateCode")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        DebugFlags.logD(response + "是否显示验证码");
                        try {
                            JSONObject json =new JSONObject(response);
                            String data=json.getString("data");
                            if ("0".equals(data)){
                                rlYzm.setVisibility(View.GONE);
                                iv_showCode.setVisibility(View.GONE);
                            }else{
                                rlYzm.setVisibility(View.VISIBLE);
                                iv_showCode.setVisibility(View.VISIBLE);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });


    }

    private void setShowcode() {
        Date date = new Date();
        mStr = date.getTime();
        String Url = Constants.BASE_URL + "/common/rand_ver_image?uid="+ mStr;

        Picasso
                .with(this)
                .load(Url)
                .into(iv_showCode);

    }

    @Override
    public void onClick(View v) {
        setShowcode();

    }

    @OnClick(R.id.bt_login)
    public void onViewClicked() {

        isShowCode();


        login();


    }

    private void login() {

      /*  Request:
        {
 “email”:””,
 “password”:””            //密码必须为8位以上，包含字母、数字或特殊字符  des加密 约定密钥 uway2017Cloud
 “ver_code”:””               //验证码，在连续登录超过3次之后会出现验证码，此时需要传该参数
“uid”:””                     //时间戳 long型
        }*/
        String mUser = etUser.getText().toString();
        String mPwd = etPwd.getText().toString();
        String mYzm = etYzm.getText().toString();
        if (TextUtils.isEmpty(mUser) || TextUtils.isEmpty(mPwd)) {

            ToastUtil.showInCenter("账号密码或者验证码不能为空");
            return;
        }
      /*  if (!realCode.equalsIgnoreCase(mYzm)) {

            ToastUtil.showInCenter("验证码错误");
            return;
        }*/


        Date date = new Date();
        long str = date.getTime();
        String mp = null;
        try {
            mp = EncryptUtils.encryption(mPwd, "uway2017Cloud");
        } catch (Exception e) {
            e.printStackTrace();
        }
        DebugFlags.logD("加密" + new Gson().toJson(new User(mUser, mp, mYzm, mStr + "")));
        OkHttpUtils.postString()
                .url(Constants.BASE_URL + "/user/login")
                .addHeader("Content-Type", "application/json")
                .mediaType(MediaType.parse("application/json; charset=utf-8")) //设置post的字符串为json字符串并设置编码 .content(new Gson().toJson(new User("zhy", "123"))) //用Gson将User对象转化为Json字符串的形式作为content .build() .execute(new MyStringCallback());
                .content(new Gson().toJson(new User(mUser, mp, mYzm, mStr + ""))) //用Gson将User对象转化为Json字符串的形式作为content
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
            DebugFlags.logD("登录成功"+response);
            SharedPrefUtil.saveString(LoginActivity.this,"name",etUser.getText().toString());
            SharedPrefUtil.saveString(LoginActivity.this,"pwd",etPwd.getText().toString());
            try {
                JSONObject json = new JSONObject(response);
                String code = json.getString("code");
                String msg = json.getString("msg");
                String data = json.getString("data");
                if ("200".equals(code)) {
                    JSONObject json1 = new JSONObject(data);
                    String sid = json1.getString("sid");
                    String companyId = json1.getString("companyId");
                    SharedPrefUtil.saveString(LoginActivity.this,"sid",sid);
                    SharedPrefUtil.saveString(LoginActivity.this,"companyId",companyId);

                    startActivity(new Intent(LoginActivity.this, MainActivity.class));

                } else {
                    ToastUtil.show(msg);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }


}
