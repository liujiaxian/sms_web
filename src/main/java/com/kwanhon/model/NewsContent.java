package com.kwanhon.model;

import com.kwanhon.common.db.BaseModel;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
@Table(name="t_news_content")
public class NewsContent extends BaseModel {
    @Id
    @Column(name = "news_id")
    public Long newsId;

    @Column(name = "source")
    public String source;

    @Column(name = "content")
    public String content;

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        set(getMetaData(this.getClass()).getColumnMapping().get("newsId"), newsId);
        this.newsId = newsId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        set(getMetaData(this.getClass()).getColumnMapping().get("source"), source);
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        set(getMetaData(this.getClass()).getColumnMapping().get("content"), content);
        this.content = content;
    }
}
