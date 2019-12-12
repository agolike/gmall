package com.agolike.gmall.manage.service;

import com.agolike.gmall.bean.PmsBaseAttrInfo;
import com.agolike.gmall.bean.PmsBaseAttrValue;
import com.agolike.gmall.bean.PmsBaseSaleAttr;
import com.agolike.gmall.manage.mapper.AttrInfoMapper;
import com.agolike.gmall.manage.mapper.AttrValueMapper;
import com.agolike.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.agolike.gmall.service.AttrInfoService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AttrInfoServiceImpl implements AttrInfoService {
    @Autowired
    AttrInfoMapper attrInfoMapper;
    @Autowired
    AttrValueMapper attrValueMapper;
    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;


    /*
    * 根据分类id获取平台属性
    * */
    @Override
    public List<PmsBaseAttrInfo> getAttrInfoListByC3Id(String catalog3Id) {
        return attrInfoMapper.getAttrInfoListByC3Id(catalog3Id);
    }

    /*
    * 根据平台属性id获取平台属性值
    * */
    @Override
    public List<PmsBaseAttrValue> getAttrValueListByAttrId(String attrId) {
        return attrValueMapper.getAttrValueListByAttrId(attrId);
    }

    /*
    * 保存更新平台属性和值
    * */
    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        //获取info对象的主键
        String id = pmsBaseAttrInfo.getId();
        //判断主键，空则是插入操作，不为空则为更新操作
        if (id == null){
            //插入操作，插入info对象返回主键，分别为value设置info对象主键，保存value对象
            attrInfoMapper.insertSelective(pmsBaseAttrInfo);
            id = pmsBaseAttrInfo.getId();
            for (PmsBaseAttrValue pmsBaseAttrValue : pmsBaseAttrInfo.getAttrValueList()) {
                pmsBaseAttrValue.setAttrId(id);
                attrValueMapper.insertSelective(pmsBaseAttrValue);
            }

        }else {
            //更新操作，根据info的id把所有value对象全部删除，分别为value设置info对象主键，保存value对象

            //根据info主键删除value对象
            PmsBaseAttrValue pmsBaseAttrValue1 = new PmsBaseAttrValue();
            pmsBaseAttrValue1.setAttrId(id);
            attrValueMapper.delete(pmsBaseAttrValue1);

            //为value对象设置attrId，并添加
            for (PmsBaseAttrValue pmsBaseAttrValue : pmsBaseAttrInfo.getAttrValueList()) {
                pmsBaseAttrValue.setAttrId(id);
                attrValueMapper.insertSelective(pmsBaseAttrValue);
            }

            //更新info对象
            Example example = new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id",id);
            attrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo,example);
        }



        return null;
    }

    /*
    * 获取销售属性
    * */
    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }
}
