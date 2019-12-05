package com.agolike.gmall.service;

import com.agolike.gmall.bean.PmsBaseAttrInfo;
import com.agolike.gmall.bean.PmsBaseAttrValue;

import java.util.List;

public interface AttrInfoService {
    List<PmsBaseAttrInfo> getAttrInfoListByC3Id(String catalog3Id);
    public List<PmsBaseAttrValue> getAttrValueListByAttrId(String attrId);
}
