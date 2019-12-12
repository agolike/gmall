package com.agolike.gmall.user.service.Impl;



import com.agolike.gmall.bean.UmsMember;
import com.agolike.gmall.service.UserService;
import com.agolike.gmall.user.Mapper.UserMapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<UmsMember> findAll() {
        return userMapper.findAll();
    }
}
