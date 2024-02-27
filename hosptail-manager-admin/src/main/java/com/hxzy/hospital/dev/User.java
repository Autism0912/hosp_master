package com.hxzy.hospital.dev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @Description TODO
 * @Author ghl
 * @Date 2023/7/12 10:43
 * @email 815835618@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String address;
}
