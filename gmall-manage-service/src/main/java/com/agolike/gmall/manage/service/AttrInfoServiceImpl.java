package com.agolike.gmall.manage.service;

import com.agolike.gmall.bean.PmsBaseAttrInfo;
import com.agolike.gmall.bean.PmsBaseAttrValue;
import com.agolike.gmall.manage.mapper.AttrInfoMapper;
import com.agolike.gmall.manage.mapper.AttrValueMapper;
import com.agolike.gmall.service.AttrInfoService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AttrInfoServiceImpl implements AttrInfoService {
    @Autowired
    AttrInfoMapper attrInfoMapper;
    @Autowired
    AttrValueMapper attrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> getAttrInfoListByC3Id(String catalog3Id) {
        return attrInfoMapper.getAttrInfoListByC3Id(catalog3Id);
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueListByAttrId(String attrId) {
        return attrValueMapper.getAttrValueListByAttrId(attrId);
    }
}
