package com.ft.ft_asset.filter;

import com.ft.ft_asset.common.MyException;
import com.ft.ft_asset.param.AssetParam;
import com.ft.ft_asset.pojo.AsAsstes;
import com.ft.ft_asset.service.AsAsstesService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "userFilter")
public class UserFilter implements Filter {
    @Autowired
    private AsAsstesService asAsstesService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("================初始化过滤器===================");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        AssetParam param = new AssetParam();
//        param.setUserName("张三");
//        PageInfo<AsAsstes> pageInfo =  asAsstesService.getAsAssetsList(param);
//        if(pageInfo.getTotal()==0){
//            throw new MyException("500","校验身份失败！");
//        }
        System.out.println("=================在过滤器里验证身份====================");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("=================过滤器放行====================");
    }

    @Override
    public void destroy() {
        System.out.println("==========================销毁过滤器===================");
    }
}
