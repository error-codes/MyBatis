package com.young.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/14 11:42
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer userId;

    private String userName;

    private Integer age;
}
