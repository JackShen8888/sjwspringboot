package com.ft.ft_asset.Intercepter;

import com.ft.ft_asset.common.MyException;
import com.ft.ft_asset.param.AssetParam;
import com.ft.ft_asset.pojo.AsAsstes;
import com.ft.ft_asset.service.AsAsstesService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyIntercepter implements HandlerInterceptor {
    Logger log = LoggerFactory.getLogger(MyIntercepter.class);
    @Autowired
    AsAsstesService asAsstesService;
    /**
     * 进入controller方法之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("================第一个拦截器前置处理preHandle===================");
        //业务处理判断拦截
        //true放行
        //false不放行
      return true;
    }

    /**
     * 方法内部处理完成，页面渲染之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        /**
         * 获取不到注入的对象asAsstesService
         */
//        AssetParam param = new AssetParam();
//        param.setUserName("张三");
//        PageInfo<AsAsstes> pageInfo =  asAsstesService.getAsAssetsList(param);
//        if(pageInfo.getTotal()==0){
//            throw new MyException("500","未获取该用户信息！");
//        }
        System.out.println("================第一个拦截器处理postHandle===================");
    }

    /**
     * 页面渲染之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("================第一个拦截器后置处理afterCompletion===================");
    }
}
