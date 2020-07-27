package com.network.good.dto;

public class LoginRes {
    private int code;
    private boolean success=false;
    public LoginRes(int code){
        this.code=code;
        if(code==0){
            this.success=true;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
