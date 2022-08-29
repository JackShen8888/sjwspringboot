package com.ft.ft_asset.common;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Response {
    private String code;
    private Object data;
    private String msg;

    public static Response buildSuccessResponse(){
        Response response = new Response();
        response.code = "200";
        response.data = null;
        response.msg = "成功";
        return response;
    }

    public static Response buildSuccessResponse(Object data,String msg){
        Response response = new Response();
        response.code = "200";
        response.data = data;
        response.msg = msg;
        return response;
    }

    public static Response buildSuccessResponse(Object data){
        Response response = new Response();
        response.code = "200";
        response.msg = "请求成功";
        if(data instanceof PageInfo){
            PageInfo pageInfo = (PageInfo)data;
            JSONObject resultJson = new JSONObject();
            resultJson.put("total", pageInfo.getTotal());
            resultJson.put("pageSize", pageInfo.getSize());
            resultJson.put("list", pageInfo.getList());
            resultJson.put("pageNum", pageInfo.getPageNum());
            response.data = resultJson;
        }else {
            response.data = data;
        }
        return response;
    }

    public static Response buildResponse(String code,String msg){
        Response response = new Response();
        response.code = code;
        response.data = null;
        response.msg = msg;
        return response;
    }
    public static Response buildFailedResponse(String msg){
        Response response = new Response();
        response.code = "500";
        response.data = null;
        response.msg = msg;
        return response;
    }
    public static Response buildFailedResponse(){
        Response response = new Response();
        response.code = "500";
        response.data = null;
        response.msg = "请求失败";
        return response;
    }
}
