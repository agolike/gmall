package com.agolike.gmall.user.Mapper;


import com.agolike.gmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UmsMember> {
    public List<UmsMember> findAll();
}
