package com.login.mapper;

import org.apache.ibatis.annotations.Param;

public interface update_client {
    void update_client(@Param("username") String username, @Param("password") String password);
}
