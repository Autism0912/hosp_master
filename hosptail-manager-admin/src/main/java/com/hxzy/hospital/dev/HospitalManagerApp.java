package com.hxzy.hospital.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * @author Ghl
 * @createTime 2023/4/26
 */
@SpringBootApplication
@ConfigurationPropertiesScan("com.hxzy.hospital.dev.common.config")
public class HospitalManagerApp {

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagerApp.class, args);
//        UserService userService = new UserService();
//        List<User> users = userService.findUserByParamToPage(5, 5);
//        System.out.println(users);

    }

}
