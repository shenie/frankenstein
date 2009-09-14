package net.shenie.domain;

import java.util.Date;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: andy
 * Date: Sep 8, 2009
 * Time: 10:00:02 PM
 */
public class Article {
    private Integer id;
    private String name;
    private String content;
    private String authorName;
    private Set comments;
    private Date createdAt;
    private Date updatedAt;

    public Article() {
    }

    public Article(ModelBuilder<Article> builder) {
        builder.build(this);
    }

    public Set getComments() {
        return comments;
    }

    public void setComments(Set comments) {
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
