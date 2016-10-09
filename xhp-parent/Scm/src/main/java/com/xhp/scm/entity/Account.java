package com.xhp.scm.entity;


/**
 * Created by xhp on 2016/9/30.
 */
public class Account {

    private static final long serialVersionUID = 8971557569763969226L;

    private Integer accId;

    private String accLogin;

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public String getAccLogin() {
        return accLogin;
    }

    public void setAccLogin(String accLogin) {
        this.accLogin = accLogin;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccPass() {
        return accPass;
    }

    public void setAccPass(String accPass) {
        this.accPass = accPass;
    }

    private String accName;

    private String accPass;

    @Override
    public String toString() {
        return "Account{" +
                "accId=" + accId +
                ", accLogin='" + accLogin + '\'' +
                ", accName='" + accName + '\'' +
                ", accPass='" + accPass + '\'' +
                '}';
    }
}
