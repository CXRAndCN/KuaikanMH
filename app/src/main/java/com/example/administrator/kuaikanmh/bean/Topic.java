package com.example.administrator.kuaikanmh.bean;

/**
 * Created by aaa on 15-4-25.
 */
public class Topic {
    private   int comics_count,order,id,user_id;
    private   String cover_image_url,description,title;
    private long created_at,updated_at;

    public int getComics_count() {
        return comics_count;
    }

    public void setComics_count(int comics_count) {
        this.comics_count = comics_count;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getCover_image_url() {
        return cover_image_url;
    }

    public void setCover_image_url(String cover_image_url) {
        this.cover_image_url = cover_image_url;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
