package com.agolike.gmall.manage.service;

import com.agolike.gmall.bean.PmsProductInfo;
import com.agolike.gmall.manage.mapper.PmsProductInfoMapper;
import com.agolike.gmall.service.SpuService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        Example example = new Example(PmsProductInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("catalog3Id",catalog3Id);
        return pmsProductInfoMapper.selectByExample(example);
    }
}
