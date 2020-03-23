package com.network.user.mapper;

import com.network.api.beans.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    TUser login(@Param("username") String username, @Param("password") String password);
}
