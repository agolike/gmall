package com.agolike.gmall.manage.service;

import com.agolike.gmall.bean.PmsProductImage;
import com.agolike.gmall.bean.PmsProductInfo;
import com.agolike.gmall.bean.PmsProductSaleAttr;
import com.agolike.gmall.bean.PmsProductSaleAttrValue;
import com.agolike.gmall.manage.mapper.PmsProductImageMapper;
import com.agolike.gmall.manage.mapper.PmsProductInfoMapper;
import com.agolike.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.agolike.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.agolike.gmall.service.SpuService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    PmsProductImageMapper pmsProductImageMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;


    /*
    * 查询3级分类下的所有spu
    * */
    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        Example example = new Example(PmsProductInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("catalog3Id",catalog3Id);
        return pmsProductInfoMapper.selectByExample(example);
    }

    /*
    * 添加spu
    * */
    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        //添加spu
        pmsProductInfoMapper.insertSelective(pmsProductInfo);
        String productId = pmsProductInfo.getId();
        //添加spuimage
        List<PmsProductImage> spuImageList = pmsProductInfo.getSpuImageList();
        for (PmsProductImage pmsProductImage : spuImageList) {
            pmsProductImage.setProductId(productId);
            pmsProductImageMapper.insertSelective(pmsProductImage);
        }
        //添加spusaleattr
        List<PmsProductSaleAttr> spuSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr pmsProductSaleAttr : spuSaleAttrList) {
            pmsProductSaleAttr.setProductId(productId);
            pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);
            //添加spusaleattrvalue
            List<PmsProductSaleAttrValue> spuSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : spuSaleAttrValueList) {
                pmsProductSaleAttrValue.setProductId(productId);
                pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            }
        }


    }
}
