package com.hxzy.hospital.dev.manage.dto;


import com.hxzy.hospital.dev.user.entity.HosRepo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RepoDto extends HosRepo {
    private String deptName;

    private Integer seeCount;
}
