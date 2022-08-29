package com.ft.ft_asset.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Slf4j
public class SimpleHttpClientUtil {

    public static String sendGet(String url, Map<String, Object> map) {
        log.info("请求url {},参数{}", url,JSON.toJSON(map));
        StringBuffer body = new StringBuffer();
        for (Map.Entry entry : map.entrySet()) {
            //map的value不为空,才会拼接在url中
            if (StringUtils.isNotBlank(entry.getValue().toString())) {
                body.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        //是否要默认加key?暂时没有加key
        String param = body.toString().substring(0, body.toString().length() - 1);
        return HttpUtil.createPost(url).body(param).charset("utf-8").execute().body();
    }

    /**
     * 模拟请求    post 请求
     *
     * @param url 资源地址
     * @param map 参数列表
     * @return
     * @throws IOException
     */
    public static String send(String url, Map<String, String> map) throws IOException {
        String body = "";

        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        //装填参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        //设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

//        log.info("请求地址：" + url + "请求参数：" + nvps.toString());

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, "utf-8");
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
//        log.info("返回结果:" + body);
        return body;
    }

    /**
     * 模拟请求  post 请求
     *
     * @param url 资源地址
     * @param map 参数列表
     * @return
     * @throws IOException
     */
    public static String sendXianYu(String url, Map<String, String> map) throws IOException {
        String body = "";

        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        //装填参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        //设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

       log.info("请求地址：" + url + "请求参数：" + nvps.toString());

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
        httpPost.addHeader("Content-type", "application/json");
        httpPost.addHeader("User-Agent", "apifox/1.0.0 (https://www.apifox.cn)");

        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, "utf-8");
        }
        System.out.println("body>>"+body);
        EntityUtils.consume(entity);
        //释放链接
        response.close();
       log.info("返回结果:" + body);
        return body;
    }

    /**
     * 模拟请求  post 请求
     *
     * @param url 资源地址
     * @param bodyString 参数json格式
     * @return
     * @throws IOException
     */
    public static String sendXianYuBody(String url, String bodyString) throws IOException {
        String result = "";
        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        //设置参数到请求对象中
        httpPost.setEntity(new StringEntity(bodyString, ContentType.create("application/json", "utf-8")));
        log.info("请求地址：" + url + "请求参数：" + bodyString);

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
        httpPost.addHeader("Content-type", "application/json");
        httpPost.addHeader("User-Agent", "apifox/1.0.0 (https://www.apifox.cn)");

        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            result = EntityUtils.toString(entity, "utf-8");
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        log.info("返回结果:" + result);
        return result;
    }
}
