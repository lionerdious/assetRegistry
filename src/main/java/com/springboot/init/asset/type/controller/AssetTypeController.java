package com.springboot.init.asset.type.controller;

import com.springboot.init.asset.type.entity.AssetType;
import com.springboot.init.asset.type.service.AssetTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class AssetTypeController {

    @Autowired
    private AssetTypeService assetTypeService;

    @GetMapping(value="/assettype/list")
    public String assetTypeList(Model model){
        List<AssetType> assetTypeList = assetTypeService.findAll();
        model.addAttribute("assetTypes",assetTypeList);
        return "assettype/list";
    }

    @PostMapping(value = "/assettype/searchlist")
    public String searchAssetTypes(Model model,@ModelAttribute AssetType assetType){

        if (assetType.getActiveStatus() != null &  assetType.getAssetTypeName() != null){
            List<AssetType> searchedAssetType =  assetTypeService.findByAssetTypeNameAndActiveStatus(assetType.getAssetTypeName(),assetType.getActiveStatus());
            model.addAttribute("assetTypes",searchedAssetType);
            return "assetType/list";
        }
        return "assettype/list";
    }


    @RequestMapping(value = "/assettype/action/{Id}", method = RequestMethod.GET)
    public String pdfOutputsaction( Model model, @PathVariable("Id") Integer Id) {
        AssetType assetType = assetTypeService.findById(Id);
        assetType = assetType == null ? new AssetType() : assetType;
        model.addAttribute("assetType", assetType);
        return "assettype/action";

    }

    @PostMapping(value = "/assettype/assettypeform")
    public String fileUpload( Model model, @ModelAttribute AssetType assetType, RedirectAttributes redirectAttributes){
        // Save
        String msg = assetTypeService.save(assetType);
        redirectAttributes.addFlashAttribute("msg","setMsg('" + msg + "')");
        return "redirect:/assettype/list";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAutoGrowCollectionLimit(500000);
    }


}
