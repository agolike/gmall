package com.agolike.gmall.service;

import com.agolike.gmall.bean.PmsBaseCatalog1;
import com.agolike.gmall.bean.PmsBaseCatalog2;
import com.agolike.gmall.bean.PmsBaseCatalog3;

import java.util.List;

public interface CatelogService {
    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
