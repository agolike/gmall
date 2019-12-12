package com.agolike.gmall.manage.controller;

import com.agolike.gmall.bean.PmsBaseAttrInfo;
import com.agolike.gmall.bean.PmsBaseAttrValue;
import com.agolike.gmall.bean.PmsBaseSaleAttr;
import com.agolike.gmall.service.AttrInfoService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class AttrInfoController {
    @Reference
    AttrInfoService attrInfoService;


    /*
    * 获取所有的销售属性
    * */
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        List<PmsBaseSaleAttr> pmsBaseSaleAttrList = attrInfoService.baseSaleAttrList();
        return pmsBaseSaleAttrList;
    }


    /*
    * 保存更新平台属性和值
    * */
    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        String flag = attrInfoService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }

    /*
    * 根据3级分类id获取平台属性
    * */
    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo> pmsBaseAttrInfoList =attrInfoService.getAttrInfoListByC3Id(catalog3Id);
        return pmsBaseAttrInfoList;
    }

    /*
    * 根据平台属性获取平台属性值
    * */
    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue> pmsBaseAttrValueList = attrInfoService.getAttrValueListByAttrId(attrId);
        return pmsBaseAttrValueList;
    }
}
