package com.ft.ft_asset;


import com.github.pagehelper.PageHelper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;
import org.apache.ibatis.plugin.Interceptor;

import java.util.Properties;


@SpringBootApplication
@EnableAsync
//@org.mybatis.spring.annotation.MapperScan("com.ft.ft_asset.mapper")
////@ComponentScan("com.ft.ft_asset.service")
////@MapperScan("com.ft.ft_asset.mapper")
////@EntityScan("com.ft.ft_asset.pojo")
////@ComponentScan(basePackages = {"com.ft.ft_asset.*"})
////@ServletComponentScan
public class SjwspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SjwspringbootApplication.class, args);
    }
   @Bean
    PageHelper pageHelper(){
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //添加插件
        new SqlSessionFactoryBean().setPlugins(new Interceptor[]{});
        return pageHelper;
    }



}
