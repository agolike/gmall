package com.agolike.gmall.user.service.Impl;

import com.agolike.gmall.bean.UmsMember;
import com.agolike.gmall.service.UserService;
import com.agolike.gmall.user.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<UmsMember> findAll() {
        return userMapper.findAll();
    }
}
