package com.agolike.gmall.service;

import com.agolike.gmall.bean.PmsBaseAttrInfo;
import com.agolike.gmall.bean.PmsBaseAttrValue;
import com.agolike.gmall.bean.PmsBaseSaleAttr;

import java.util.List;

public interface AttrInfoService {
    List<PmsBaseAttrInfo> getAttrInfoListByC3Id(String catalog3Id);
    public List<PmsBaseAttrValue> getAttrValueListByAttrId(String attrId);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
