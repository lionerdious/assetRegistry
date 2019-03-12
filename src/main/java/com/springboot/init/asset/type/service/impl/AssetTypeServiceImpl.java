package com.springboot.init.asset.type.service.impl;

import com.springboot.init.asset.type.dao.AssetTypeDao;
import com.springboot.init.asset.type.entity.AssetType;
import com.springboot.init.asset.type.service.AssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetTypeServiceImpl implements AssetTypeService {

    @Autowired
    private AssetTypeDao assetTypeDao;

    @Override
    public List<AssetType> findByAssetTypeName(String assetTypeName) {
        return assetTypeDao.findByAssetTypeName(assetTypeName);
    }

    @Override
    public List<AssetType> findByAssetTypeNameAndActiveStatus(String assetTypeName, Boolean activeStatus) {
        return assetTypeDao.findByAssetTypeNameAndActiveStatus(assetTypeName,activeStatus);
    }

    @Override
    public List<AssetType> findByActiveStatus(Boolean activeStatus) {
        return assetTypeDao.findByActiveStatus(activeStatus);
    }

    @Override
    public String save(AssetType assetType) {
        assetTypeDao.save(assetType);
        return "Asset Type created";
    }

    @Override
    public AssetType findById(int Id) {
        return assetTypeDao.findById(Id);
    }

    @Override
    public List<AssetType> findAll() {
        return assetTypeDao.findAll();
    }


}
