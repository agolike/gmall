package com.agolike.gmall.manage.controller;

import com.agolike.gmall.bean.PmsProductInfo;
import com.agolike.gmall.manage.util.PmsUploadUtil;
import com.agolike.gmall.service.SpuService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {
    @Reference
    SpuService spuService;

    /*
    * 保存spu
    * */
    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    /*
    * 上传图片到图片服务器，返回url
    * */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        String url = PmsUploadUtil.uploadImage(multipartFile);
        return url;
    }



    /*
    * 根据3级id查询所有spu
    * */
    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfoList = spuService.spuList(catalog3Id);
        return pmsProductInfoList;
    }
}
