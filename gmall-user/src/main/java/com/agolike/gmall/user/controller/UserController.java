package com.agolike.gmall.user.controller;

import com.agolike.gmall.user.bean.UmsMember;
import com.agolike.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("findAll")
    @ResponseBody
    public List<UmsMember> findAll(){
        return userService.findAll();
    }
}
