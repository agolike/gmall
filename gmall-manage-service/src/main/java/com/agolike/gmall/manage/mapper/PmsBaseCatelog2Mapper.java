package com.agolike.gmall.manage.mapper;

import com.agolike.gmall.bean.PmsBaseCatalog2;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PmsBaseCatelog2Mapper {
    @Select("select * from pms_base_catalog2 where catalog1_id = #{catalog1Id}")
    public List<PmsBaseCatalog2> getCatalog2ByCatalog1Id(String catalog1Id);
}
