package com.retrofit.app;

import java.io.Serializable;
import java.util.List;

public class PostBeanList implements Serializable {
    private List<PostBean> postdata;
    private String msg;

    public List<PostBean> getPostdata() {
        return postdata;
    }

    public void setPostdata(List<PostBean> postdata) {
        this.postdata = postdata;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
