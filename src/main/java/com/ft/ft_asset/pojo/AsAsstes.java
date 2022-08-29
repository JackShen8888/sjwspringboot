package com.ft.ft_asset.pojo;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "as_asstes")
@Data
@Entity
public class AsAsstes {
    @Column(name = "id")
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "asstesId")
    private String asstesId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userDep")
    private String userDep;
    @Column(name = "purchasePrice")
    private String purchasePrice;
    @Column(name = "postDate")
    private String postDate;
    @Column(name = "userDate")
    private String userDate;
    @Column(name = "location")
    private String location;
    @Column(name = "asstesStatus")
    private String asstesStatus;
    @Column(name = "company")
    private String company;
    @Column(name = "asstesType")
    private String asstesType;
    @Column(name = "asstesName")
    private String asstesName;
    @Column(name = "asstesModel")
    private String asstesModel;
    @Column(name = "supplier")
    private String supplier;
    @Column(name = "remark")
    private String remark;
    @Column(name = "recordDate")
    private String recordDate;
    @Column(name = "lastUpdateTime")
    private Date lastUpdateTime;
    @Column(name = "isDel")
    private Integer isDel;
}
