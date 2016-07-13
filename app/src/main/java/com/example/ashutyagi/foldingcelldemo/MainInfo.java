package com.example.ashutyagi.foldingcelldemo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainInfo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("article_link")
    @Expose
    private String articleLink;
    @SerializedName("short_url")
    @Expose
    private Object shortUrl;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;
    @SerializedName("published")
    @Expose
    private Integer published;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The articleLink
     */
    public String getArticleLink() {
        return articleLink;
    }

    /**
     *
     * @param articleLink
     * The article_link
     */
    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    /**
     *
     * @return
     * The shortUrl
     */
    public Object getShortUrl() {
        return shortUrl;
    }

    /**
     *
     * @param shortUrl
     * The short_url
     */
    public void setShortUrl(Object shortUrl) {
        this.shortUrl = shortUrl;
    }

    /**
     *
     * @return
     * The thumbnailUrl
     */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     *
     * @param thumbnailUrl
     * The thumbnail_url
     */
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    /**
     *
     * @return
     * The published
     */
    public Integer getPublished() {
        return published;
    }

    /**
     *
     * @param published
     * The published
     */
    public void setPublished(Integer published) {
        this.published = published;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}