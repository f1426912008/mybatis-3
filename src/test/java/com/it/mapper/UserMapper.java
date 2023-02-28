package com.it.mapper;

import com.it.bean.User;
import org.apache.ibatis.annotations.*;

/**
 * @author 范亚鑫
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2023-01-26 19:07:53
 * @Entity com.it.bean.User
 */
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") String id);

    @Insert("insert into user(id, name, age, email, version, create_time, update_time, is_delete) " +
            "values (#{id}, #{name}, #{age}, #{email}, #{version}, NOW(), NOW(), '0')")
    Integer addUser(User user);

}




