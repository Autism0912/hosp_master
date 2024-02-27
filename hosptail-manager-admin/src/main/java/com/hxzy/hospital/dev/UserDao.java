package com.hxzy.hospital.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author ghl
 * @Date 2023/7/12 14:27
 * @email 815835618@qq.com
 */
public class UserDao {
    public List<User> findAll(){
        List<User> userList = new ArrayList<>(Arrays.asList(
                new User(1,"name","西安"),
                new User(2,"name","address"),
                new User(3,"name","address"),
                new User(4,"name","address"),
                new User(5,"name","address"),
                new User(6,"name","address"),
                new User(7,"name","address"),
                new User(8,"name","address"),
                new User(9,"name","address"),
                new User(10,"name","address"),
                new User(11,"name","address"),
                new User(12,"name","address"),
                new User(13,"name","address"),
                new User(14,"name","address"),
                new User(15,"name","address"),
                new User(16,"name","address"),
                new User(17,"name","address"),
                new User(18,"name","address"),
                new User(19,"name","address"),
                new User(20,"name","address"),
                new User(21,"name","address"),
                new User(22,"name","")
        ));

        return  userList;
    }
}
