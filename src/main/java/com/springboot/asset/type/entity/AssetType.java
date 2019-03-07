package com.springboot.asset.type.entity;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Data
@Table(name = "asset_type")
public class AssetType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int asset_id;

    @Column(name = "asset_type_name")
    private String assetTypeName;

    @Column(name = "active_status")
    private Boolean activeStatus;

}
