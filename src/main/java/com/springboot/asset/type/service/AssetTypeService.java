package com.springboot.asset.type.service;

import com.springboot.asset.type.entity.AssetType;

import java.util.List;

public interface AssetTypeService {
    public List<AssetType> findByAssetTypeName(String assetTypeName);
    public List<AssetType> findByAssetTypeNameAndActiveStatus(String assetTypeName, Boolean activeStatus);
    public List<AssetType> findByActiveStatus(Boolean activeStatus);
    public String save(AssetType assetType);
    public AssetType findById(int Id);
    public List<AssetType> findAll();
}

