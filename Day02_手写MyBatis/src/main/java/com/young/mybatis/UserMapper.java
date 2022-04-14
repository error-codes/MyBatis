package com.young.mybatis;

import com.young.entity.User;

import java.util.List;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/14 11:40
 */
public interface UserMapper {

    @Select("SELECT * FROM user WHERE user_id = #{id}")
    User getUserById();

    @Select("SELECT * FROM user")
    List<User> listUser();
}
