package dao.cn.com.alb.view.bean;

/**
 * @name dao.cn.com.alb.view.bean
 * @class name：Alb
 * @class describe
 * @anthor uway QQ:343251588
 * @time 2018/2/12 9:38
 * @change uway
 * @chang 2018/2/12 9:38
 * @class describe
 */
/*"date":"20180205","downFlowSum":7986673.0,"upFlowSum":2093111.0*/

public class Flow {
    private  String date;
    private  String downFlowSum;
    private  String upFlowSum;

    public Flow () {
    }

    public Flow (String date, String downFlowSum, String upFlowSum) {
        this.date = date;
        this.downFlowSum = downFlowSum;
        this.upFlowSum = upFlowSum;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDownFlowSum() {
        return downFlowSum;
    }

    public void setDownFlowSum(String downFlowSum) {
        this.downFlowSum = downFlowSum;
    }

    public String getUpFlowSum() {
        return upFlowSum;
    }

    public void setUpFlowSum(String upFlowSum) {
        this.upFlowSum = upFlowSum;
    }
}
