package com.agolike.gmall.manage.mapper;

import com.agolike.gmall.bean.PmsBaseCatalog2;
import com.agolike.gmall.bean.PmsBaseCatalog3;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PmsBaseCatelog3Mapper {
    @Select("select * from pms_base_catalog3 where catalog2_id = #{catalog2Id}")
    public List<PmsBaseCatalog3> getCatalog3ByCatalog2Id(String catalog2Id);
}
