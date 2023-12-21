package com.example.lab2;

public class Post {
    private String avatarUrl;
    private String userName;
    private String postTitle;
    private String postText;
    private boolean isLiked;

    public Post(String avatarUrl, String userName, String postTitle, String postText, boolean isLiked) {
        this.avatarUrl = avatarUrl;
        this.userName = userName;
        this.postTitle = postTitle;
        this.postText = postText;
        this.isLiked = isLiked;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPostTitle() {
        return postTitle;
    }
    public String getPostText() {
        return postText;
    }

    public boolean isLiked() {
        return isLiked;
    }
}
