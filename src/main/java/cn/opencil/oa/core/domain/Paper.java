package cn.opencil.oa.core.domain;

import java.io.File;
import java.io.InputStream;
import java.sql.Date;

/**
 * Created with Sdut-jsj-OA.
 * Package: cn.opencil.oa.core.domain
 * User: 张树伟
 * Date: 16-11-28
 * Time: 下午12:37
 */
public class Paper {
    private String uuid;
    private String title; // 论文题目
    private String author; // 第一作者
    private String particpants; // 参与者
    private Integer level; // 刊物级别 : 核心期刊、一般期刊
    private Date publishedDate; // 发表时间
    private Integer type; // 检索类型 : 无、EI检索、SCI检索、CSCD检索、ISTP检索、CSSCI检索
    private String volumePeriod; // 卷期
    private String annex; // 附件地址
    private String schoolYear;
    private File annexFile;
    private InputStream inputStream;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getParticpants() {
        return particpants;
    }

    public void setParticpants(String particpants) {
        this.particpants = particpants;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getVolumePeriod() {
        return volumePeriod;
    }

    public void setVolumePeriod(String volumePeriod) {
        this.volumePeriod = volumePeriod;
    }

    public String getAnnex() {
        return annex;
    }

    public void setAnnex(String annex) {
        this.annex = annex;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public File getAnnexFile() {
        return annexFile;
    }

    public void setAnnexFile(File annexFile) {
        this.annexFile = annexFile;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", particpants='" + particpants + '\'' +
                ", level=" + level +
                ", publishedDate='" + publishedDate + '\'' +
                ", type=" + type +
                ", volumePeriod='" + volumePeriod + '\'' +
                ", annex='" + annex + '\'' +
                ", schoolYear=" + schoolYear +
                '}';
    }
}
