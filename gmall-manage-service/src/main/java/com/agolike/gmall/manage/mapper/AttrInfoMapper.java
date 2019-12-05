package com.agolike.gmall.manage.mapper;

import com.agolike.gmall.bean.PmsBaseAttrInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AttrInfoMapper {
    @Select("select * from pms_base_attr_info where catalog3_id = #{catalog3Id}")
    List<PmsBaseAttrInfo> getAttrInfoListByC3Id(String catalog3Id);

    @Delete("delete from pms_base_attr_info where id = {id}")
    void deleteById(String id);

    @Update("update pms_base_attr_info set attr_name=#{attrName},is_enabled=#{isEnabled} where id ={id} ")
    void updateAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    @Insert("insert into pms_base_attr_info () values(#{attrName},#{catalog3Id},#{isEnabled})")
    void addAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

}
