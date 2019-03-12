package com.springboot.init.asset.type.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "asset_type")
public class AssetType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int asset_id;

    private String assetTypeName;

    private Boolean activeStatus;

}
