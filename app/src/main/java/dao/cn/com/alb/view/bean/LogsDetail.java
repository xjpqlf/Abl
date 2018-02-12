package dao.cn.com.alb.view.bean;

/**
 * @name dao.cn.com.alb.view.bean
 * @class name：Alb
 * @class describe
 * @anthor uway QQ:343251588
 * @time 2018/2/11 19:01
 * @change uway
 * @chang 2018/2/11 19:01
 * @class describe
 *
"id": null,
"deviceid": "863920030168780",
"mac": "b0e5edaf5ece3c67fc70d6c0",
"url": "www.baidu.com",
"urlLen": 13,
"srcIp": "-1062706074",
"srcFmtIp": "192.168.100.102",
"srcPort": 40182,
"dstIp": "-1209473108",
"dstFmtIp": "183.232.231.172",
"dstPort": 80,
"enilType": 10,
"createDate": "2018-02-08 19:17:26:179",
"createTime": "2018-02-08 19:17:26",
"status": null,
"times": 0,
"enilTypeName": "黑名单",
"userId": null,
"companyId": null
 *
 *
 */


public class LogsDetail {
    private String id;
    private String deviceid;
    private String mac;
    private String url;
    private String urlLen;
    private String srcIp;
    private String srcFmtIp;
    private String srcPort;
    private String dstIp;
    private String dstFmtIp;
    private String dstPort;
    private String enilType;
    private String createDate;
    private String createTime;
    private String status;
    private String enilTypeName;
    private String userId;
    private String companyId;

    public LogsDetail() {
    }

    public LogsDetail(String id, String deviceid, String mac, String url, String urlLen, String srcIp, String srcFmtIp, String srcPort, String dstIp, String dstFmtIp, String dstPort, String enilType, String createDate, String createTime, String status, String enilTypeName, String userId, String companyId) {
        this.id = id;
        this.deviceid = deviceid;
        this.mac = mac;
        this.url = url;
        this.urlLen = urlLen;
        this.srcIp = srcIp;
        this.srcFmtIp = srcFmtIp;
        this.srcPort = srcPort;
        this.dstIp = dstIp;
        this.dstFmtIp = dstFmtIp;
        this.dstPort = dstPort;
        this.enilType = enilType;
        this.createDate = createDate;
        this.createTime = createTime;
        this.status = status;
        this.enilTypeName = enilTypeName;
        this.userId = userId;
        this.companyId = companyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlLen() {
        return urlLen;
    }

    public void setUrlLen(String urlLen) {
        this.urlLen = urlLen;
    }

    public String getSrcIp() {
        return srcIp;
    }

    public void setSrcIp(String srcIp) {
        this.srcIp = srcIp;
    }

    public String getSrcFmtIp() {
        return srcFmtIp;
    }

    public void setSrcFmtIp(String srcFmtIp) {
        this.srcFmtIp = srcFmtIp;
    }

    public String getSrcPort() {
        return srcPort;
    }

    public void setSrcPort(String srcPort) {
        this.srcPort = srcPort;
    }

    public String getDstIp() {
        return dstIp;
    }

    public void setDstIp(String dstIp) {
        this.dstIp = dstIp;
    }

    public String getDstFmtIp() {
        return dstFmtIp;
    }

    public void setDstFmtIp(String dstFmtIp) {
        this.dstFmtIp = dstFmtIp;
    }

    public String getDstPort() {
        return dstPort;
    }

    public void setDstPort(String dstPort) {
        this.dstPort = dstPort;
    }

    public String getEnilType() {
        return enilType;
    }

    public void setEnilType(String enilType) {
        this.enilType = enilType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnilTypeName() {
        return enilTypeName;
    }

    public void setEnilTypeName(String enilTypeName) {
        this.enilTypeName = enilTypeName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
