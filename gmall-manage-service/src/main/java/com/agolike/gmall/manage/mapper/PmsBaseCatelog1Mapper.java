package com.agolike.gmall.manage.mapper;

import com.agolike.gmall.bean.PmsBaseCatalog1;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PmsBaseCatelog1Mapper {
    @Select("select * from pms_base_catalog1")
    public List<PmsBaseCatalog1> getCatalog1();
}
