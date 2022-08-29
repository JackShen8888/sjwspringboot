package com.ft.ft_asset.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ft.ft_asset.common.MyException;
import com.ft.ft_asset.mapper.AsAsstesMapper;
import com.ft.ft_asset.param.AssetParam;
import com.ft.ft_asset.pojo.AsAsstes;
import com.ft.ft_asset.service.AsAsstesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class AsAssetsServiceImpl implements AsAsstesService {
    @Autowired
    private AsAsstesMapper asAsstesMapper;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public PageInfo<AsAsstes> getAsAssetsList(AssetParam param) {
        Example example = new Example(AsAsstes.class);
        example.createCriteria().andEqualTo("userName",param.getUserName()).andEqualTo("isDel",0);
        PageHelper.startPage(1,10);
        PageHelper.orderBy("id");
        List<AsAsstes> list = asAsstesMapper.selectByExample(example);
        PageInfo<AsAsstes> pageInfo = new PageInfo(list);
        return pageInfo;
    }
    @Override
    public PageInfo<AsAsstes> getAssetLike(AssetParam param) {
        PageHelper.startPage(param.getPageNum(),param.getPageSize());
        PageHelper.orderBy("id asc");
        List<AsAsstes> list = asAsstesMapper.getAssetLike(param);
        PageInfo<AsAsstes> pageInfo = new PageInfo(list);
        return pageInfo;
    }
    @Override
    public List<AsAsstes> getAsAssetsListV2(AssetParam param) {
        Example example = new Example(AsAsstes.class);
        example.createCriteria().andEqualTo("userName",param.getUserName());
        List<AsAsstes> list = asAsstesMapper.selectByExample(example);
        return list;
    }

    @Override
    public void saveAsset(AsAsstes asset) {
        asset.setId(null);
        asset.setRecordDate(simpleDateFormat.format(new Date()));
        asset.setIsDel(0);
        asAsstesMapper.insert(asset);
    }

    @Override
    public void updateAsset(AsAsstes asset) {
        if(asset.getId()==null){
            throw new MyException("500","缺少id！");
        }
        AsAsstes assetUpdate = asAsstesMapper.selectByPrimaryKey(asset.getId());
        if(assetUpdate==null){
            throw new MyException("500","该物品不存在！");
        }
        assetUpdate.setUserName(asset.getUserName());
        assetUpdate.setAsstesName(asset.getAsstesName());
        assetUpdate.setAsstesStatus(asset.getAsstesStatus());
        assetUpdate.setLastUpdateTime(new Date());
        asAsstesMapper.updateByPrimaryKey(assetUpdate);
    }

    @Override
    public void deleteAsset(AsAsstes asset) {
        if(asset.getId()==null){
            throw new MyException("500","缺少id！");
        }
        AsAsstes assetDelete = asAsstesMapper.selectByPrimaryKey(asset.getId());
        if(assetDelete==null){
            throw new MyException("500","该物品不存在！");
        }
        assetDelete.setIsDel(1);
        assetDelete.setLastUpdateTime(new Date());
        asAsstesMapper.updateByPrimaryKey(assetDelete);
    }
}
