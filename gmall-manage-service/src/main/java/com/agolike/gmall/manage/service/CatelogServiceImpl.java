package com.agolike.gmall.manage.service;

import com.agolike.gmall.bean.PmsBaseCatalog1;
import com.agolike.gmall.bean.PmsBaseCatalog2;
import com.agolike.gmall.bean.PmsBaseCatalog3;
import com.agolike.gmall.manage.mapper.PmsBaseCatelog1Mapper;
import com.agolike.gmall.manage.mapper.PmsBaseCatelog2Mapper;
import com.agolike.gmall.manage.mapper.PmsBaseCatelog3Mapper;
import com.agolike.gmall.service.CatelogService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CatelogServiceImpl implements CatelogService {
    @Autowired
    PmsBaseCatelog1Mapper pmsBaseCatelog1Mapper;
    @Autowired
    PmsBaseCatelog2Mapper pmsBaseCatelog2Mapper;
    @Autowired
    PmsBaseCatelog3Mapper pmsBaseCatelog3Mapper;

    /*获取一级分类*/
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatelog1Mapper.getCatalog1();
    }

    /*获取二级分类*/
    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        return pmsBaseCatelog2Mapper.getCatalog2ByCatalog1Id(catalog1Id);
    }

    /*获取三级分类*/
    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        return pmsBaseCatelog3Mapper.getCatalog3ByCatalog2Id(catalog2Id);
    }

}
