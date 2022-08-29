package com.ft.ft_asset.entity.easyExcelEntity;

import lombok.Data;

import java.util.List;
@Data
public class User {
    private Long id;

    private String name;

    private String age;

    private List<Score> list;


}
