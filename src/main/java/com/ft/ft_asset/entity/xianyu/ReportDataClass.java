package com.ft.ft_asset.entity.xianyu;


// ReportDataClass.java


/**
 * 验货报告信息，仅已验货自检商品类型传入===
 */
public class ReportDataClass {
    private BeautyMakeupClass beautyMakeup;
    private CurioClass curio;
    private GameClass game;
    private JewelryClass jewelry;
    private UsedCarClass usedCar;
    private ValuableClass valuable;
    private VirtualAccountClass virtualAccount;

    /**
     * 美妆信息，仅美妆分类传入
     */
    public BeautyMakeupClass getBeautyMakeup() { return beautyMakeup; }
    public void setBeautyMakeup(BeautyMakeupClass value) { this.beautyMakeup = value; }

    /**
     * 文玩信息，仅文玩分类传入
     */
    public CurioClass getCurio() { return curio; }
    public void setCurio(CurioClass value) { this.curio = value; }

    /**
     * 游戏信息，仅信息分类传入
     */
    public GameClass getGame() { return game; }
    public void setGame(GameClass value) { this.game = value; }

    /**
     * 珠宝信息，仅珠宝分类传入
     */
    public JewelryClass getJewelry() { return jewelry; }
    public void setJewelry(JewelryClass value) { this.jewelry = value; }

    /**
     * 二手车信息，仅二手车分类传入
     */
    public UsedCarClass getUsedCar() { return usedCar; }
    public void setUsedCar(UsedCarClass value) { this.usedCar = value; }

    /**
     * 奢品信息，仅奢品分类传入
     */
    public ValuableClass getValuable() { return valuable; }
    public void setValuable(ValuableClass value) { this.valuable = value; }

    /**
     * 虚拟账号/租号信息，仅虚拟账号/租号分类传入
     */
    public VirtualAccountClass getVirtualAccount() { return virtualAccount; }
    public void setVirtualAccount(VirtualAccountClass value) { this.virtualAccount = value; }
}