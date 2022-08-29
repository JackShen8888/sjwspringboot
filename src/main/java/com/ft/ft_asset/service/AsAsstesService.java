package com.ft.ft_asset.service;

import com.ft.ft_asset.param.AssetParam;
import com.ft.ft_asset.pojo.AsAsstes;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AsAsstesService {
    PageInfo<AsAsstes> getAsAssetsList(AssetParam param);

    PageInfo<AsAsstes> getAssetLike(AssetParam param);

    List<AsAsstes> getAsAssetsListV2(AssetParam param);

    void saveAsset(AsAsstes asset);

    void updateAsset(AsAsstes asset);

    void deleteAsset(AsAsstes asset);
}
