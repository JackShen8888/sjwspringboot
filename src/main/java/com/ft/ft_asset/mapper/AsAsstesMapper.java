package com.ft.ft_asset.mapper;

import com.ft.ft_asset.param.AssetParam;
import com.ft.ft_asset.pojo.AsAsstes;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface AsAsstesMapper extends Mapper<AsAsstes>, MySqlMapper<AsAsstes> {
    @Select(
            "<script>"+
                    " select * from as_asstes where asstesName like concat('%',#{asset.assetName},'%') and isDel = 0"+
            "</script>"
    )
    List<AsAsstes> getAssetLike(@Param("asset") AssetParam param);
}
