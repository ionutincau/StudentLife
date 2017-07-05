package com.whiteshadow.studentlife.domain;

import android.net.Uri;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Incau Ionut on 05-Jul-17.
 * Contact: ionut.incau@gmail.com
 */

@Entity
public class Article {
    @Id(autoincrement = true)
    private Long id;
    private String title;
    private String image_location;

    public Article() {

    }

    public Article(String title, String image_location) {
        this.title = title;
        this.image_location = image_location;
    }

    @Generated(hash = 1246805698)
    public Article(Long id, String title, String image_location) {
        this.id = id;
        this.title = title;
        this.image_location = image_location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_location() {
        return image_location;
    }

    public void setImage_location(String image_location) {
        this.image_location = image_location;
    }

    public Uri getUri() {
        return Uri.parse(image_location);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
