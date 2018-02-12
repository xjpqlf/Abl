package dao.cn.com.alb.view.utils;

import android.view.Gravity;
import android.widget.Toast;

import dao.cn.com.alb.view.Ablapplication;

/**
 * Created by liuhuan-mac on 16/5/3.
 */
public class ToastUtil {
    public static void showInCenter(int strId) {

        Ablapplication context = Ablapplication.getInstance();

        Toast toast = Toast.makeText(context,strId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    public static void showInCenter(String str) {
        Ablapplication context =  Ablapplication.getInstance();
        Toast toast = Toast.makeText(context,str, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    public static void show(int strId) {
        Ablapplication context =  Ablapplication.getInstance();
        Toast toast = Toast.makeText(context,strId, Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void show(String str) {
        Ablapplication context =  Ablapplication.getInstance();
        Toast toast = Toast.makeText(context,str, Toast.LENGTH_SHORT);
        toast.show();
    }


    /**
     * 获取版本号
     * @return 当前应用的版本号
     */

}
