package com.newb.apollo.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author qinghui
 * @Description: TODO
 * @date 2019/7/12 10:35
 */
public class TestJavaConfigBean {
    @Value("${timeout:0}")
    private int timeout;
    private int batch;
    @Value("${kp.show.picture.upload.button}")
    private String showBtnCorpId;

    @Value("${batch:0}")
    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getBatch() {
        return batch;
    }

    public String getShowBtnCorpId() {
        return showBtnCorpId;
    }

    public void setShowBtnCorpId(String showBtnCorpId) {
        this.showBtnCorpId = showBtnCorpId;
    }

    @Override
    public String toString() {
        return "TestJavaConfigBean{" +
                "timeout=" + timeout +
                ", batch=" + batch +
                ", showBtnCorpId='" + showBtnCorpId + '\'' +
                '}';
    }
}
