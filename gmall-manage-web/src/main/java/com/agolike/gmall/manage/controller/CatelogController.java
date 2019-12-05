package com.agolike.gmall.manage.controller;

import com.agolike.gmall.bean.PmsBaseCatalog1;
import com.agolike.gmall.bean.PmsBaseCatalog2;
import com.agolike.gmall.bean.PmsBaseCatalog3;
import com.agolike.gmall.service.CatelogService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
@CrossOrigin
public class CatelogController {
    @Reference
    CatelogService catelogService;


    /*
     * 获取三级级分类
     * */
    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3( String catalog2Id){
        /*调用service层，获取一个list一级分类对象的集合*/
        List<PmsBaseCatalog3> pmsBaseCatalog3List = catelogService.getCatalog3(catalog2Id);
        return pmsBaseCatalog3List;
    }


    /*
    * 获取二级分类
    * */
    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2( String catalog1Id){
        /*调用service层，获取一个list一级分类对象的集合*/
        List<PmsBaseCatalog2> pmsBaseCatalog2List = catelogService.getCatalog2(catalog1Id);
        return pmsBaseCatalog2List;
    }

    /*
    * 获取一级分类
    * */
    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){
        /*调用service层，获取一个list一级分类对象的集合*/
        List<PmsBaseCatalog1> pmsBaseCatalog1List = catelogService.getCatalog1();
        return pmsBaseCatalog1List;
    }
}
