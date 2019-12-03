package com.agolike.gmall.user.controller;



import com.agolike.gmall.bean.UmsMember;
import com.agolike.gmall.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Reference
    UserService userService;
    @RequestMapping("findAll")
    @ResponseBody
    public List<UmsMember> findAll(){
        List<UmsMember> all = userService.findAll();
        return userService.findAll();
    }
}
