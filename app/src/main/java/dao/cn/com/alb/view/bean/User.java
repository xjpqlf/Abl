package dao.cn.com.alb.view.bean;

/**
 * @name dao.cn.com.alb.view.bean
 * @class name：Alb
 * @class describe
 * @anthor uway QQ:343251588
 * @time 2018/2/9 16:56
 * @change uway
 * @chang 2018/2/9 16:56
 * @class describe
 */


public class User {
    public String email;
    public String password;
    public String ver_code;
    public String uid;

    public User() {
    }

    public User(String email, String password, String ver_code, String uid) {
        this.email = email;
        this.password = password;
        this.ver_code = ver_code;
        this.uid = uid;
    }
}
