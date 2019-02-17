package com.example.user.chat2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    public enum ItemType {
        ONE_ITEM, TWO_ITEM
    }

    private ItemType type;

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    private String id;
    private String username;
    private String imageURL;
    private String status;

    public User(String id, String username, String imageURL, String status,ItemType type) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        if (imageURL != null)
            return imageURL;
        else
            return "default";
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    protected User(Parcel in) {
        id = in.readString();
        username = in.readString();
        imageURL = in.readString();
        status = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(username);
        dest.writeString(imageURL);
        dest.writeString(status);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}