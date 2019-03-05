package com.kwanhon.model;

import com.kwanhon.common.db.BaseModel;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
@Table(name = "t_news")
public class News extends BaseModel {
    @Id
    @Column(name = "news_id")
    public Long newsId;

    @Column(name = "title")
    public String title;

    @Column(name = "image_url")
    public String imageUrl;

    @Column(name = "summary")
    public String summary;

    @Column(name = "type_id")
    public Integer typeId;

    @Column(name = "type_name")
    public String typeName;

    @Column(name = "publish_time")
    public String publishTime;

    @Column(name = "create_time")
    public String createTime;

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        set(getMetaData(this.getClass()).getColumnMapping().get("newsId"), newsId);
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        set(getMetaData(this.getClass()).getColumnMapping().get("title"), title);
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        set(getMetaData(this.getClass()).getColumnMapping().get("imageUrl"), imageUrl);
        this.imageUrl = imageUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        set(getMetaData(this.getClass()).getColumnMapping().get("summary"), summary);
        this.summary = summary;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        set(getMetaData(this.getClass()).getColumnMapping().get("typeId"), typeId);
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        set(getMetaData(this.getClass()).getColumnMapping().get("typeName"), typeName);
        this.typeName = typeName;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        set(getMetaData(this.getClass()).getColumnMapping().get("publishTime"), publishTime);
        this.publishTime = publishTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        set(getMetaData(this.getClass()).getColumnMapping().get("createTime"), createTime);
        this.createTime = createTime;
    }
}
