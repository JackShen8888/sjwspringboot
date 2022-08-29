package com.ft.ft_asset;

import com.alibaba.fastjson.JSONObject;
import com.ft.ft_asset.param.AssetParam;
import com.ft.ft_asset.pojo.AsAsstes;
import com.ft.ft_asset.service.AsAsstesService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyTest {
    @Autowired
    private AsAsstesService asAsstesService;
    @Test
    public void test1(){
        AssetParam param = new AssetParam();
        param.setAssetName("DELL台式机");
        PageInfo<AsAsstes> res = asAsstesService.getAsAssetsList(param);
        System.out.println(11111);
    }

    @Test
    public void test2(){
        AssetParam param = new AssetParam();
        param.setAssetName("DELL台式机");
        List<AsAsstes> res = asAsstesService.getAsAssetsListV2(param);
        System.out.println(JSONObject.toJSONString(res.get(0)));
    }
}
