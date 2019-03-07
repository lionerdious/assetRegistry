package com.springboot.asset.type.dao;

import com.springboot.asset.type.entity.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetTypeDao extends JpaRepository<AssetType, Integer> {
    public AssetType findByAssetTypeName(String assetTypeName);
    public AssetType findByAssetTypeNameAndActiveStatus(String assetTypeName, Boolean activeStatus);
    public List<AssetType> findByActiveStatus(Boolean activeStatus);
    public AssetType findById(int Id);
}
