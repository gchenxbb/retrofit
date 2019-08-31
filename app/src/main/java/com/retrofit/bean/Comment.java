package com.retrofit.bean;

import java.io.Serializable;

public class Comment implements Serializable {


    private static final long serialVersionUID = 6241007474213104268L;
    private String id;
    private String body;
    private String postId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
