package com.ft.ft_asset.config;
import com.ft.ft_asset.Intercepter.LocaleInterceptor;
import com.ft.ft_asset.Intercepter.MyIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CommonConfig implements WebMvcConfigurer{

    // 这个方法是用来配置静态资源的，比如html，js，css等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    // 对所有访问路径，都通过MyInterceptor类型的拦截器进行拦截
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对所有访问路径，都通过MyInterceptor类型的拦截器进行拦截
        registry.addInterceptor(new MyIntercepter()).addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/index.html", "/user/login", "/css/**", "/images/**", "/js/**", "/fonts/**");

        registry.addInterceptor(new LocaleInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/index.html", "/user/login", "/css/**", "/images/**", "/js/**", "/fonts/**");
    }
}
