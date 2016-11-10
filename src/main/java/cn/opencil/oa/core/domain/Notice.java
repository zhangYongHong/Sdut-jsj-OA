package cn.opencil.oa.core.domain;

import java.sql.Date;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.domain
 * User: 张树伟
 * Date: 16-11-9
 * Time: 下午9:19
 */
// 通知
public class Notice {
    private String uuid;
    private String title;
    private String content; // 内容
    private String user;
    private Date beginDate; // 开始时间

    public String getUuid() {
        return uuid;
    }
    
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
}
