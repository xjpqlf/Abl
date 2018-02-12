package dao.cn.com.alb.view.bean;

/**
 * @name dao.cn.com.alb.view.bean
 * @class name：Alb
 * @class describe
 * @anthor uway QQ:343251588
 * @time 2018/2/11 11:34
 * @change uway
 * @chang 2018/2/11 11:34
 * @class describe
 */


public class Infos {
    private  String num;
    private  String time;
    private  String type;
    private  String adress;

    public Infos() {
    }

    public Infos(String num, String time, String type, String adress) {
        this.num = num;
        this.time = time;
        this.type = type;
        this.adress = adress;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
