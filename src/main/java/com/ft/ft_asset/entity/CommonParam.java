package com.ft.ft_asset.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CommonParam {
    
    public static String app_key = "3607c5f95326a420faf2f85667479f73";
    public static String sign_type = "0";
    public static String signed_at = new Date().getTime()+"";
    public static String sign;
}
