package com.network.good.dto;

public class UpdatePassw {
    private String name;
    private String oldpassw;
    private String newpassw;
    private String verifypassw;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOldpassw() {
        return oldpassw;
    }

    public void setOldpassw(String oldpassw) {
        this.oldpassw = oldpassw;
    }

    public String getNewpassw() {
        return newpassw;
    }

    public void setNewpassw(String newpassw) {
        this.newpassw = newpassw;
    }

    public String getVerifypassw() {
        return verifypassw;
    }

    public void setVerifypassw(String verifypassw) {
        this.verifypassw = verifypassw;
    }
}
