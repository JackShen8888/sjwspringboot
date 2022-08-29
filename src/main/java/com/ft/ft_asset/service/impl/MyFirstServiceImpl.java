package com.ft.ft_asset.service.impl;

import com.ft.ft_asset.service.MyFirstService;
import org.springframework.stereotype.Component;

@Component
public class MyFirstServiceImpl implements MyFirstService {
    @Override
    public void testService() {
        System.out.println("=======testService运行中======");
    }
}
