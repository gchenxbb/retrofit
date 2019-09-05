package com.retrofit.bean;

import java.io.Serializable;

public class Post implements Serializable {

    private static final long serialVersionUID = -1244616750248114044L;
    private int postId;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
