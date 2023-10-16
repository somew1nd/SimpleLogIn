package com.login.mapper;

import com.login.pojo.client;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface get_client {
    @Select("select * from sql_hr.tb_user where username = #{username}")
    client get_by_name(@Param("username") String username);
   // @Select("select * from sql_hr.tb_user where username = #{username} and password = #{password}")
    client get_by_NameAndPassword(@Param("username") String username, @Param("password") String password);
}
