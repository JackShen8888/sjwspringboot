package com.ft.ft_asset.controller;

import com.ft.ft_asset.common.Response;
import com.ft.ft_asset.entity.User;
import com.ft.ft_asset.util.RedisUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    RedisUtil redisUtil;
    @PostMapping(value = "/login")
    @ResponseBody
    public Response login(@RequestBody @Param("user") User user){
        if(user.getUserName().equals("张三")&&user.getPwd().equals("123456")){
            redisUtil.set("user:login:"+user.getUserNo(),user);
            return Response.buildSuccessResponse("登陆成功！");
        }else {
            return Response.buildFailedResponse("登陆失败！");
        }
    }
    @GetMapping(value = "/loginOut")
    public Response loginOut(@Param("userNo") String userNo){
        if(redisUtil.hasKey("user:login:"+userNo)){
            redisUtil.del("user:login:"+userNo);
            return Response.buildSuccessResponse("登出成功！");
        }else {
            return Response.buildFailedResponse("未检验到登录状态！");
        }
    }
}
