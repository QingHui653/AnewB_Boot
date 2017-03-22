package com.newb.mybatis.db.entity;

import javax.persistence.*;

public class Result {
    @Id
    private Integer oid;

    @Column(name = "f_1")
    private String f1;

    @Column(name = "f_2")
    private String f2;

    @Column(name = "f_3")
    private String f3;

    @Column(name = "f_4")
    private String f4;

    @Column(name = "f_5")
    private String f5;

    /**
     * @return oid
     */
    public Integer getOid() {
        return oid;
    }

    /**
     * @param oid
     */
    public void setOid(Integer oid) {
        this.oid = oid;
    }

    /**
     * @return f_1
     */
    public String getF1() {
        return f1;
    }

    /**
     * @param f1
     */
    public void setF1(String f1) {
        this.f1 = f1;
    }

    /**
     * @return f_2
     */
    public String getF2() {
        return f2;
    }

    /**
     * @param f2
     */
    public void setF2(String f2) {
        this.f2 = f2;
    }

    /**
     * @return f_3
     */
    public String getF3() {
        return f3;
    }

    /**
     * @param f3
     */
    public void setF3(String f3) {
        this.f3 = f3;
    }

    /**
     * @return f_4
     */
    public String getF4() {
        return f4;
    }

    /**
     * @param f4
     */
    public void setF4(String f4) {
        this.f4 = f4;
    }

    /**
     * @return f_5
     */
    public String getF5() {
        return f5;
    }

    /**
     * @param f5
     */
    public void setF5(String f5) {
        this.f5 = f5;
    }
}