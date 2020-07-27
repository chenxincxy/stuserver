package com.network.good.dto;

import com.network.good.Enum.UserStateEnum;

public class UpdateRes {
    private boolean success;
    private String message;

    public UpdateRes(boolean success,UserStateEnum userStateEnum){
        this.success=success;
        this.message=userStateEnum.getStateinfo();
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
