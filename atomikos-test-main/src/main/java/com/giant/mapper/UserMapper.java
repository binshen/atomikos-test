package com.giant.mapper;

import com.giant.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user (name) VALUES (#{name})")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", resultType=int.class, before=false)
    int insertUser(User user);
}
