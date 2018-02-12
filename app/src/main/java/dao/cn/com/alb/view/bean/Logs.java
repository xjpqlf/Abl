package dao.cn.com.alb.view.bean;

/**
 * @name dao.cn.com.alb.view.bean
 * @class name：Alb
 * @class describe
 * @anthor uway QQ:343251588
 * @time 2018/2/11 18:10
 * @change uway
 * @chang 2018/2/11 18:10
 * @class describe
 */
/*      .ALL:""//可忽略
                .companyId:10012
                sid
                .pageNo:1//当前页码
                .pageSize:10//当前条数
                .url:""//可忽略*/

public class Logs {
    private String  ALL;
    private String  companyId;
    private String  status;

    private String  pageNo;
    private String  pageSize;
    private String  url;

    public Logs(String companyId) {
        this.companyId = companyId;
    }

    public Logs(String companyId, String status) {
        this.companyId = companyId;
        this.status = status;
    }

    public Logs(String ALL, String companyId, String pageNo, String pageSize, String url) {
        this.ALL = ALL;
        this.companyId = companyId;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.url = url;
    }
}
