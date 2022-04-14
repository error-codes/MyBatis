package com.young.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/14 13:41
 */
public class Application {

    public static void main(String[] args) {

        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(Application.class.getClassLoader(), new Class[]{UserMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println(method.getName());
                return null;
            }
        });

        userMapper.getUserById();
        userMapper.listUser();
    }
}
