package com.ft.ft_asset.Intercepter;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocaleInterceptor extends LocaleChangeInterceptor {
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
                             Object handler) throws ServletException {
        super.preHandle(request,response,handler);
        System.out.println("================第二个拦截器preHandle===================");
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
        super.postHandle(request,response,handler,modelAndView);
        System.out.println("================第二个拦截器postHandle===================");
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
        super.afterCompletion(request,response,handler,ex);
        System.out.println("================第二个拦截器afterCompletion===================");
    }
}
