package com.ft.ft_asset.controller;

import com.ft.ft_asset.common.Response;
import com.ft.ft_asset.param.AssetParam;
import com.ft.ft_asset.pojo.AsAsstes;
import com.ft.ft_asset.service.AsAsstesService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Controller+@ResponseBody两个注解的结合

@RequestMapping(value = "/api/asset")
@RestController
public class AsAssetsController {
    @Autowired
    private AsAsstesService asAsstesService;

    /**
     * 查询资产
     * @param param
     * @return
     */
    @PostMapping(value = "/getAsAssetsList")
    @ResponseBody
    public Response getAsAssetsList(@RequestBody AssetParam param){
        System.out.println("=========getAsAssetsList接口===========");
        PageInfo<AsAsstes> pageInfo =  asAsstesService.getAsAssetsList(param);
        return Response.buildSuccessResponse(pageInfo);
    }
    /**
     * 模糊查询资产
     * @param param
     * @return
     */
    @PostMapping(value = "/getAssetLike")
    @ResponseBody
    public Response getAssetLike(@RequestBody AssetParam param){
        System.out.println("=========getAssetLike接口===========");
        PageInfo<AsAsstes> pageInfo =  asAsstesService.getAssetLike(param);
        return Response.buildSuccessResponse(pageInfo);
    }

    /**
     * 增加资产
     * @param asset
     * @return
     */
    @PostMapping(value = "/saveAsset")
    @ResponseBody
    public Response saveAsset(@RequestBody AsAsstes asset){
        System.out.println("=========saveAsset接口===========");
        asAsstesService.saveAsset(asset);
        return Response.buildSuccessResponse();
    }
    /**
     * 更新资产
     * @param asset
     * @return
     */
    @PostMapping(value = "/updateAsset")
    @ResponseBody
    public Response updateAsset(@RequestBody AsAsstes asset){
        System.out.println("=========updateAsset接口===========");
        asAsstesService.updateAsset(asset);
        return Response.buildSuccessResponse();
    }
    /**
     * 删除资产
     * @param asset
     * @return
     */
    @PostMapping(value = "/deleteAsset")
    @ResponseBody
    public Response deleteAsset(@RequestBody AsAsstes asset){
        System.out.println("=========deleteAsset接口===========");
        asAsstesService.deleteAsset(asset);
        return Response.buildSuccessResponse();
    }
}
