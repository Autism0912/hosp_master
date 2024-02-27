package com.hxzy.hospital.dev;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @Description TODO
 * @Author ghl
 * @Date 2023/7/12 14:28
 * @email 815835618@qq.com
 */
public class UserService {
    public List<User> findUserByParamToPage(Integer index, Integer pageSize){
        UserDao userDao = new UserDao();
        List<User> all = userDao.findAll();
        List<User> collect = all.stream()
                /**
                 * 过滤address为""的数据
                 */
                .filter(user -> {
                    return all.stream().anyMatch(user1 -> user1.getAddress().contains("西"));
                }).collect(Collectors.toList());


        return collect;
    }
}
