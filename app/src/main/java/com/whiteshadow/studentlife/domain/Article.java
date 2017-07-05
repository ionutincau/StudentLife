package com.whiteshadow.studentlife.domain;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Incau Ionut on 05-Jul-17.
 * Contact: ionut.incau@gmail.com
 */

@Entity
public class Article implements Parcelable {
    @Id(autoincrement = true)
    private Long id;
    private String title;
    private String image_location;

    private String content;

    public Article() {

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeLong(id);
        out.writeString(title);
        out.writeString(image_location);
        out.writeString(content);
    }

    public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>() {
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    private Article(Parcel in) {
        id = in.readLong();
        title = in.readString();
        image_location = in.readString();
        content = in.readString();
    }

    @Generated(hash = 423972810)
    public Article(Long id, String title, String image_location, String content) {
        this.id = id;
        this.title = title;
        this.image_location = image_location;
        this.content = content;
    }
}
