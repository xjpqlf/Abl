package dao.cn.com.alb.view.bean;

/**
 * @name dao.cn.com.alb.view.bean
 * @class name：Alb
 * @class describe
 * @anthor uway QQ:343251588
 * @time 2018/2/11 20:03
 * @change uway
 * @chang 2018/2/11 20:03
 * @class describe
 */
/*enilType":"黑名单","docCount":9019*/

public class MyPieData {
    private String enilType;
    private String docCount;

    public MyPieData() {
    }

    public MyPieData(String enilType, String docCount) {
        this.enilType = enilType;
        this.docCount = docCount;
    }

    public String getEnilType() {
        return enilType;
    }

    public void setEnilType(String enilType) {
        this.enilType = enilType;
    }

    public String getDocCount() {
        return docCount;
    }

    public void setDocCount(String docCount) {
        this.docCount = docCount;
    }
}
