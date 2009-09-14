package net.shenie.domain;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: andy
 * Date: Sep 8, 2009
 * Time: 10:00:15 PM
 */
public class Comment {
    private Integer id;
    private Article article;
    private String authorName;
    private String siteUrl;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    public Comment() {
    }

    public Comment(ModelBuilder<Comment> builder) {
        builder.build(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
