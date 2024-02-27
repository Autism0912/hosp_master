package com.hxzy.hospital.dev.userCenter.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditPassword {
    private Integer id;
    private String username;
    private String oldpassword;
    private String pword;
    private String pword2;
}
