package com.zhaike.controller;

import com.zhaike.entity.Users;
import com.zhaike.entity.UsersExample;
import com.zhaike.mapping.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersMapper usersMapper;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/new")
    public ModelAndView newftl(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("new");
        mav.addObject("num",1000);
        return mav;
    }

    @RequestMapping("/login")
    @ResponseBody
    public List<Users> findByname(Users users){
        UsersExample ue = new UsersExample();
        ue.createCriteria().andNicknameEqualTo(users.getNickname()).andPasswordEqualTo(users.getPassword());
        List<Users> users1 = usersMapper.selectByExample(ue);
        return users1;
    }

}
