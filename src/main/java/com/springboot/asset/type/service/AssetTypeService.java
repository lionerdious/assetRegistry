package com.springboot.asset.type.service;

import com.springboot.asset.type.entity.AssetType;

import java.util.List;

public interface AssetTypeService {
    public AssetType findByAssetTypeName(String assetTypeName);
    public AssetType findByAssetTypeNameAndActiveStatus(String assetTypeName, Boolean activeStatus);
    public List<AssetType> findByActiveStatus(Boolean activeStatus);
    public String save(AssetType assetType);
    public AssetType findById(int Id);
    public List<AssetType> findAll();
}

