package com.example.user.chat2.model;

public class Chat {
    public enum ItemType {
        ONE_ITEM, TWO_ITEM
    }

    private User.ItemType type;

    public User.ItemType getType() {
        return type;
    }

    public void setType(User.ItemType type) {
        this.type = type;
    }
    private int id = 0;
    private String words;
    private String imageUrl;
    private String username;
    private String time;
    private  boolean issegen;
    public Chat(String words) {
        this.words = words;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
