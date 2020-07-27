package com.network.good.mapper;

import com.network.api.beans.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public User selectById(int id);

    public User selectByName(String name);

    public boolean deleteById(int id);

    public User searchById(int id,int start,int end);

    public int getTotalLines();

    public List<User> selectAll();

    public List<User> selectUsersBypage(@Param("start")int start, @Param("end") int end);

    public boolean updateUser(User user);

    public void updatePassword(@Param("id")int id,@Param("newpassword")String newpassword);
    //这里使用多参数注解指定哪个参数是哪个了，后面的mapper就不用写ParamType来区分参数类型了

}
