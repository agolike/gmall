package com.agolike.gmall.manage.mapper;

import com.agolike.gmall.bean.PmsBaseAttrValue;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AttrValueMapper extends Mapper<PmsBaseAttrValue> {
    @Select("select * from pms_base_attr_value where attr_id = #{attrId}")
    public List<PmsBaseAttrValue> getAttrValueListByAttrId(String attrId);
}
