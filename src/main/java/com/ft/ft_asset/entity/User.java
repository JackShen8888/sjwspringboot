package com.ft.ft_asset.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String userNo;
    private String userName;
    private String pwd;
    private String phone;
    private Integer workNum;
    private List<String> roles;
}
