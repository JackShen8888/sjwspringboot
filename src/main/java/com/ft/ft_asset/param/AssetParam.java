package com.ft.ft_asset.param;


import lombok.Data;

import javax.persistence.*;

@Data
public class AssetParam extends PageParam {
   private String assetName;//资产名称
   private String userName;//使用人
   private Integer assetId;//资产id

}
