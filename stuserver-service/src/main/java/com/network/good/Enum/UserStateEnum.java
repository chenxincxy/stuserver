package com.network.good.Enum;

public enum UserStateEnum {
    SUCCESS(1,"恭喜您,修改成功"),
    VERIFY_ERROP(-3,"确认密码有误"),
    Password_ERROR(-2,"原密码错误"),
    Username_ERROR(-1,"用户不存在");
    private int state;
    private String stateinfo;

    UserStateEnum(int state, String stateinfo) {
        this.state = state;
        this.stateinfo = stateinfo;
    }


    public int getState() {
        return state;
    }

    public String getStateinfo() {
        return stateinfo;
    }

    public static UserStateEnum stateOf(int index){
        for(UserStateEnum state:values()){
            if(state.getState()==index)
                return state;
        }
        return null;
    }
}
