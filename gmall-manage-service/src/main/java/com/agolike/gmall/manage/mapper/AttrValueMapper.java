package com.agolike.gmall.manage.mapper;

import com.agolike.gmall.bean.PmsBaseAttrValue;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AttrValueMapper {
    @Select("select * from pms_base_attr_value where attr_id = #{attrId}")
    public List<PmsBaseAttrValue> getAttrValueListByAttrId(String attrId);
}
