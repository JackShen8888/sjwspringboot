package com.ft.ft_asset;

import com.alibaba.fastjson.JSONObject;
import com.ft.ft_asset.entity.VhallCommonParam;
import com.ft.ft_asset.service.MyFirstService;
import com.ft.ft_asset.util.MD5Util;
import com.ft.ft_asset.util.SimpleHttpClientUtil;
import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.ft.ft_asset.util.MD5Util.*;
import static org.apache.commons.codec.digest.DigestUtils.md5;
import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SjwspringbootApplication.class)
class SjwspringbootApplicationTests {

    @Autowired
//    @Qualifier(value = "myFirstService")
    private MyFirstService myFirstService;
    @Test
 public void test1(){
        System.out.println(111);
        myFirstService.testService();
    }
    @Test
    public void test() throws IOException, ParseException {
        String secret_key = "9cc743e57a539296a587a50dedbd2ffb";
        Map map = new HashMap();
        //赋值
        VhallCommonParam vhallCommonParam = new VhallCommonParam();
        vhallCommonParam.third_user_id = "1233432456";
        vhallCommonParam.pass = "123456";
        map.put("app_key",vhallCommonParam.app_key);
        map.put("sign_type",vhallCommonParam.sign_type);
        map.put("signed_at",vhallCommonParam.signed_at);
        map.put("third_user_id",vhallCommonParam.third_user_id);
        map.put("pass",vhallCommonParam.pass);
        String signStr =  getMd5SignStr(map);
        System.out.println(secret_key +signStr  + secret_key);
        map.put("sign", MD5Util.MD5(secret_key +signStr  + secret_key).toLowerCase());

        String s = SimpleHttpClientUtil.send("https://saas-open.vhall.com/v3/users/open-user/create", map);
        System.out.println(s);
        System.out.println(111);
    }

//    appKey：开放平台提供的应用KEY
//    appSecret：开放平台提供的应用密钥
//    timestamp：发起请求时的时间戳（秒）
//    bodyString：POST原文字符串

//    appKey = 203413189371893
//    appSecret = o9wl81dncmvby3ijpq7eur456zhgtaxs
//    timestamp = 1636087298
//    bodyString = {"product_id":"219530767978565"}

//    bodyMd5 = md5({"product_id":"219530767978565"})
//    signMd5 = md5("203413189371893,$bodyMd5,1636087298,o9wl81dncmvby3ijpq7eur456zhgtaxs")

//    sign = c26c8a48809141f3dd80bd9b9ddb41ea
    @Test
    public void testSign() throws IOException {
        /**
         * 样例
         */
//        String AppKey = "203413189371893";
//        String AppSecret = "o9wl81dncmvby3ijpq7eur456zhgtaxs";
//        Long timestamp = 1636087298L;
//        Map object = new HashMap();
//        object.put("product_id","219530767978565");
//        String bodyString  = JSONObject.toJSONString(object);
//        String bodyMd5 = MD5(bodyString);
//        String signMd5 = MD5(AppKey+","+bodyMd5+","+timestamp+","+AppSecret);
//        System.out.println(signMd5);
        /**
         * 自己的闲管家
         */
        String AppKey = "321970796122181";
        String AppSecret = "4Rwz87FX5s50G4BECvnXYknZmjCl1xeD";
        Long timestamp = new Date().getTime()/1000;
        System.out.println(timestamp);
        Map map = new HashMap();
        map.put("product_id","220656347074629");
        System.out.println(JSONObject.toJSONString(map));
        String bodyMd5 = MD5(JSONObject.toJSONString(map)).toLowerCase();
        String signMd5 = MD5(AppKey+","+bodyMd5+","+timestamp+","+AppSecret).toLowerCase();
        System.out.println(bodyMd5);
        System.out.println(signMd5);
        StringBuffer sbUrl = new StringBuffer();
        sbUrl.append("https://api.goofish.pro/sop/product/query?appid=").append(AppKey).append("&timestamp=").append(timestamp).append("&sign=").append(signMd5);
        String response = SimpleHttpClientUtil.sendXianYu(sbUrl.toString(),map);

    }
    @Test
    public void testAdd() throws IOException, ParseException {
        String createGoodsUrl = "https://api.goofish.pro/sop/product/create";
        String AppKey = "321970796122181";
        String AppSecret = "lnRkaSxe6mdD7vZGrG3tIyLXCf7juss0".toLowerCase();
        Long timestamp = new Date().getTime()/1000;

        String content = "{\"item_biz_type\":2,\"sp_biz_type\":1,\"channel_cat_id\":\"e11455b218c06e7ae10cfa39bf43dc0f\",\"original_price\":700000,\"price\":550000,\"stock\":10,\"title\":\"iPhone 12 128G 黑色\",\"images\":[\"https://img10.360buyimg.com/n1/s450x450_jfs/t1/122555/23/24606/306620/6222d04bE24b868ba/b7f1e1bd2ef7c77e.jpg\",\"https://img10.360buyimg.com/n5/s54x54_jfs/t1/121049/10/15005/41016/5f8670d3Ec3fff28f/2881d50f2f7739d4.jpg\"],\"desc\":\"商品描述巴拉巴拉\",\"sku_items\":[{\"price\":500000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:白色;容量:128G\"},{\"price\":600000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:白色;容量:256G\"},{\"price\":500000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:黑色;容量:128G\"},{\"price\":600000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:黑色;容量:256G\"}],\"district_id\":320506,\"outer_id\":\"2021110112345\",\"stuff_status\":100,\"express_fee\":10,\"sp_guarantee\":\"1,2\"}";
        String bodyMd5 = MD5(content).toLowerCase();
        StringBuffer sb = new StringBuffer();
        sb.append(AppKey).append(",").append(bodyMd5).append(",").append(timestamp).append(",").append(AppSecret);
        System.out.println("准备生成sign>>"+sb.toString());
        String sign = MD5(sb.toString()).toLowerCase();
        String url = createGoodsUrl+"?appid="+AppKey+"&timestamp="+timestamp+"&sign="+sign;

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, content);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("User-Agent", "apifox/1.0.0 (https://www.apifox.cn)")
                .addHeader("Content-Type", "application/json")
                .build();

        System.out.println("发送url>>"+url);
        System.out.println("参数>>"+content);
        Response response = client.newCall(request).execute();
        System.out.println("返回结果>>"+response);
    }
    @Test
    public void testQueryOne() throws IOException {
//        String appKey = "203413189371893";
//        String appSecret = "o9wl81dncmvby3ijpq7eur456zhgtaxs";
        String appKey = "321970796122181";
        String appSecret = "4Rwz87FX5s50G4BECvnXYknZmjCl1xeD".toLowerCase();

        // String timestamp = "1636087298";
//        bodyString = {"product_id":"219530767978565"}
//        bodyMd5 = md5({"product_id":"219530767978565"})
//        signMd5 = md5("203413189371893,$bodyMd5,1636087298,o9wl81dncmvby3ijpq7eur456zhgtaxs")
        //String AppKey = "321970796122181";
        //String AppSecret = "lnRkaSxe6mdD7vZGrG3tIyLXCf7juss0";
        String timestamp = new Date().getTime()/1000+"";
        System.out.println("timestamp>>"+timestamp);
//        String content = "{\n    \"product_id\": \"220656347074629\"\n}";
        Map object = new HashMap();
        object.put("product_id","219530767978565");
        String content = JSONObject.toJSONString(object);
        System.out.println("content>>"+content);

        String bodyMd5 = md5Hex(content);

//        signMd5 = md5("203413189371893,$bodyMd5,1636087298,o9wl81dncmvby3ijpq7eur456zhgtaxs")
        StringBuffer sb = new StringBuffer();
        sb.append(appKey).append(",").append(bodyMd5).append(",").append(timestamp).append(",").append(appSecret);
        System.out.println("准备生成sign>>"+sb.toString());
        String sign = md5Hex(sb.toString());
        System.out.println("sign>>"+sign);
        String url = "https://api.goofish.pro/sop/product/query?appid="+appKey+"&timestamp="+timestamp+"&sign="+sign;
//        "https://api.goofish.pro/sop/product/query?appid={{appid}}&timestamp={{timestamp}}&sign={{sign}}"

//        OkHttpClient client = new OkHttpClient().newBuilder().build();
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, content);
//        Request request = new Request.Builder()
//                .url(url)
//                .method("POST", body)
//                .addHeader("User-Agent", "apifox/1.0.0 (https://www.apifox.cn)")
//                .addHeader("Content-Type", "application/json")
//                .build();
//        Response response1 = client.newCall(request).execute();
//        System.out.println("查询结果>>"+response1);
        String response2 = SimpleHttpClientUtil.sendXianYu(url,object);
        System.out.println("查询结果>>"+response2);
    }
    @Test
    public void testSelectOne() throws IOException {
        String appid = "321970796122181";
        String appSecret = "4Rwz87FX5s50G4BECvnXYknZmjCl1xeD";
        String timestamp = new Date().getTime()/1000+"";

        Map param = new HashMap();
        param.put("product_id","321970421291845");
        String body = JSONObject.toJSONString(param);

        String bodyMd5 = MD5GateWay(body).toLowerCase();

        StringBuffer sb = new StringBuffer();
        sb.append(appid).append(",").append(bodyMd5).append(",").append(timestamp).append(",").append(appSecret);
        System.out.println("准备生成sign>>"+sb.toString());
        String sign = MD5GateWay(sb.toString()).toLowerCase();
        System.out.println("sign>>"+sign);

        StringBuffer sbUrl = new StringBuffer();
        sbUrl.append("https://api.goofish.pro/sop/product/query?appid=").append(appid).append("&timestamp=").append(timestamp).append("&sign=").append(sign);
        SimpleHttpClientUtil.sendXianYuBody(sbUrl.toString(),body);
    }
    @Test
    public void testSelectList() throws IOException {
        String appid = "321970796122181";
        String appSecret = "4Rwz87FX5s50G4BECvnXYknZmjCl1xeD";
        String timestamp = new Date().getTime()/1000+"";

        Map param = new HashMap();
//        {
//                "start_modified":1645286400, 起始的修改时间
//                "end_modified":1645545600,结束的修改时间
//                "product_status":22,管家商品状态 22 销售中
//                "page_no":1,页码
//                "page_size":50 行
//        }
        param.put("product_status",22);
        param.put("page_no",1);
        param.put("page_size",50);
        String body = JSONObject.toJSONString(param);

        String bodyMd5 = MD5GateWay(body).toLowerCase();

        StringBuffer sb = new StringBuffer();
        sb.append(appid).append(",").append(bodyMd5).append(",").append(timestamp).append(",").append(appSecret);
        System.out.println("准备生成sign>>"+sb.toString());
        String sign = MD5GateWay(sb.toString()).toLowerCase();
        System.out.println("sign>>"+sign);

        StringBuffer sbUrl = new StringBuffer();
        sbUrl.append("https://api.goofish.pro/sop/product/list?appid=").append(appid).append("&timestamp=").append(timestamp).append("&sign=").append(sign);
        SimpleHttpClientUtil.sendXianYuBody(sbUrl.toString(),body);
    }
    @Test
    public void testAddOne() throws IOException {
        String appid = "321970796122181";
        String appSecret = "4Rwz87FX5s50G4BECvnXYknZmjCl1xeD";
        String timestamp = new Date().getTime()/1000+"";

        Map param = new HashMap();
        //String body = JSONObject.toJSONString(param);
        String body = "{\"item_biz_type\":2,\"sp_biz_type\":1,\"channel_cat_id\":\"e11455b218c06e7ae10cfa39bf43dc0f\",\"original_price\":700000,\"price\":550000,\"stock\":10,\"title\":\"iPhone 12 128G 黑色\",\"images\":[\"https://img10.360buyimg.com/n1/s450x450_jfs/t1/122555/23/24606/306620/6222d04bE24b868ba/b7f1e1bd2ef7c77e.jpg\",\"https://img10.360buyimg.com/n5/s54x54_jfs/t1/121049/10/15005/41016/5f8670d3Ec3fff28f/2881d50f2f7739d4.jpg\"],\"desc\":\"商品描述巴拉巴拉\",\"sku_items\":[{\"price\":500000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:白色;容量:128G\"},{\"price\":600000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:白色;容量:256G\"},{\"price\":500000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:黑色;容量:128G\"},{\"price\":600000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:黑色;容量:256G\"}],\"district_id\":320506,\"outer_id\":\"2021110112345\",\"stuff_status\":100,\"express_fee\":10,\"sp_guarantee\":\"1,2\"}";

        String bodyMd5 = MD5GateWay(body).toLowerCase();

        StringBuffer sb = new StringBuffer();
        sb.append(appid).append(",").append(bodyMd5).append(",").append(timestamp).append(",").append(appSecret);
        System.out.println("准备生成sign>>"+sb.toString());
        String sign = MD5GateWay(sb.toString()).toLowerCase();
        System.out.println("sign>>"+sign);

        StringBuffer sbUrl = new StringBuffer();
        sbUrl.append("https://api.goofish.pro/sop/product/create?appid=").append(appid).append("&timestamp=").append(timestamp).append("&sign=").append(sign);
        SimpleHttpClientUtil.sendXianYuBody(sbUrl.toString(),body);
    }
    @Test
    public void testAddBatch() throws IOException {
        String appid = "321970796122181";
        String appSecret = "4Rwz87FX5s50G4BECvnXYknZmjCl1xeD";
        String timestamp = new Date().getTime()/1000+"";

        Map param = new HashMap();
        //String body = JSONObject.toJSONString(param);
        String body = "[{\"item_biz_type\":2,\"sp_biz_type\":1,\"channel_cat_id\":\"e11455b218c06e7ae10cfa39bf43dc0f\",\"original_price\":700000,\"price\":550000,\"stock\":10,\"title\":\"iPhone 12 128G 黑色\",\"images\":[\"https://img10.360buyimg.com/n1/s450x450_jfs/t1/122555/23/24606/306620/6222d04bE24b868ba/b7f1e1bd2ef7c77e.jpg\",\"https://img10.360buyimg.com/n5/s54x54_jfs/t1/121049/10/15005/41016/5f8670d3Ec3fff28f/2881d50f2f7739d4.jpg\"],\"desc\":\"商品描述巴拉巴拉\",\"sku_items\":[{\"price\":500000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:白色;容量:128G\"},{\"price\":600000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:白色;容量:256G\"},{\"price\":500000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:黑色;容量:128G\"},{\"price\":600000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:黑色;容量:256G\"}],\"district_id\":320506,\"outer_id\":\"2021110112345\",\"stuff_status\":100,\"express_fee\":10,\"sp_guarantee\":\"1,2\"}]";

        String bodyMd5 = MD5GateWay(body).toLowerCase();

        StringBuffer sb = new StringBuffer();
        sb.append(appid).append(",").append(bodyMd5).append(",").append(timestamp).append(",").append(appSecret);
        System.out.println("准备生成sign>>"+sb.toString());
        String sign = MD5GateWay(sb.toString()).toLowerCase();
        System.out.println("sign>>"+sign);

        StringBuffer sbUrl = new StringBuffer();
        sbUrl.append("https://api.goofish.pro/sop/product/batchCreate?appid=").append(appid).append("&timestamp=").append(timestamp).append("&sign=").append(sign);
        SimpleHttpClientUtil.sendXianYuBody(sbUrl.toString(),body);
    }
    @Test
    public void testEdit() throws IOException {
        String appid = "321970796122181";
        String appSecret = "4Rwz87FX5s50G4BECvnXYknZmjCl1xeD";
        String timestamp = new Date().getTime()/1000+"";

        Map param = new HashMap();
        //String body = JSONObject.toJSONString(param);
        String body = "{\"item_biz_type\":2,\"sp_biz_type\":1,\"channel_cat_id\":\"e11455b218c06e7ae10cfa39bf43dc0f\",\"original_price\":700000,\"price\":550000,\"stock\":10,\"title\":\"iPhone 12 128G 黑色\",\"images\":[\"https://img10.360buyimg.com/n1/s450x450_jfs/t1/122555/23/24606/306620/6222d04bE24b868ba/b7f1e1bd2ef7c77e.jpg\",\"https://img10.360buyimg.com/n5/s54x54_jfs/t1/121049/10/15005/41016/5f8670d3Ec3fff28f/2881d50f2f7739d4.jpg\"],\"desc\":\"商品描述巴拉巴拉\",\"sku_items\":[{\"price\":500000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:白色;容量:128G\"},{\"price\":600000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:白色;容量:256G\"},{\"price\":500000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:黑色;容量:128G\"},{\"price\":600000,\"stock\":10,\"outer_id\":\"\",\"sku_text\":\"颜色:黑色;容量:256G\"}],\"district_id\":320506,\"outer_id\":\"2021110112345\",\"stuff_status\":100,\"express_fee\":10,\"sp_guarantee\":\"1,2\"}";

        String bodyMd5 = MD5GateWay(body).toLowerCase();

        StringBuffer sb = new StringBuffer();
        sb.append(appid).append(",").append(bodyMd5).append(",").append(timestamp).append(",").append(appSecret);
        System.out.println("准备生成sign>>"+sb.toString());
        String sign = MD5GateWay(sb.toString()).toLowerCase();
        System.out.println("sign>>"+sign);

        StringBuffer sbUrl = new StringBuffer();
        sbUrl.append("https://api.goofish.pro/sop/product/edit?appid=").append(appid).append("&timestamp=").append(timestamp).append("&sign=").append(sign);
        SimpleHttpClientUtil.sendXianYuBody(sbUrl.toString(),body);
    }
    @Test
    public void testDown() throws IOException {
        String appid = "321970796122181";
        String appSecret = "4Rwz87FX5s50G4BECvnXYknZmjCl1xeD";
        String timestamp = new Date().getTime()/1000+"";

        Map param = new HashMap();
        param.put("product_id","1234");
        String body = JSONObject.toJSONString(param);
        String bodyMd5 = MD5GateWay(body).toLowerCase();

        StringBuffer sb = new StringBuffer();
        sb.append(appid).append(",").append(bodyMd5).append(",").append(timestamp).append(",").append(appSecret);
        System.out.println("准备生成sign>>"+sb.toString());
        String sign = MD5GateWay(sb.toString()).toLowerCase();
        System.out.println("sign>>"+sign);

        StringBuffer sbUrl = new StringBuffer();
        sbUrl.append("https://api.goofish.pro/sop/product/downShelf?appid=").append(appid).append("&timestamp=").append(timestamp).append("&sign=").append(sign);
        SimpleHttpClientUtil.sendXianYuBody(sbUrl.toString(),body);
    }
    @Test
    public void testDel() throws IOException {
        String appid = "321970796122181";
        String appSecret = "4Rwz87FX5s50G4BECvnXYknZmjCl1xeD";
        String timestamp = new Date().getTime()/1000+"";

        Map param = new HashMap();
        param.put("product_id","123456");
        String body = JSONObject.toJSONString(param);

        String bodyMd5 = MD5GateWay(body).toLowerCase();

        StringBuffer sb = new StringBuffer();
        sb.append(appid).append(",").append(bodyMd5).append(",").append(timestamp).append(",").append(appSecret);
        System.out.println("准备生成sign>>"+sb.toString());
        String sign = MD5GateWay(sb.toString()).toLowerCase();
        System.out.println("sign>>"+sign);

        StringBuffer sbUrl = new StringBuffer();
        sbUrl.append("https://api.goofish.pro/sop/product/delete?appid=").append(appid).append("&timestamp=").append(timestamp).append("&sign=").append(sign);
        SimpleHttpClientUtil.sendXianYuBody(sbUrl.toString(),body);
    }
}
