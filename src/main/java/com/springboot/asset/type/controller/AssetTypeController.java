package com.springboot.asset.type.controller;

import com.springboot.asset.type.entity.AssetType;
import com.springboot.asset.type.service.AssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AssetTypeController {

    @Autowired
    private AssetTypeService assetTypeService;

    @GetMapping(value="/assetType/list")
    public String assetTypeList(Model model){
        List<AssetType> assetTypeList = assetTypeService.findAll();
        model.addAttribute("assetTypes",assetTypeList);
        return "assetType/list";
    }

    @PostMapping(value = "/assettype/searchlist")
    public String searchAssetTypes(Model model,@ModelAttribute AssetType assetType){

        if (assetType.getActiveStatus() != null &  assetType.getAssetTypeName() != null){
            AssetType assetType =  assetTypeService.findByAssetTypeNameAndActiveStatus(assetType.getAssetTypeName(),assetType.getActiveStatus());
            model.addAttribute("assetTypes",assetType);
            return "assetType/list";
        }
        return "assetType/list";
    }


}
