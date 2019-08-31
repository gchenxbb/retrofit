package com.retrofit.app;

import java.io.Serializable;
import java.util.List;

public class GetBeanList implements Serializable {
    private List<GetBean> postdata;
    private String msg;

    public List<GetBean> getPostdata() {
        return postdata;
    }

    public void setPostdata(List<GetBean> postdata) {
        this.postdata = postdata;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
