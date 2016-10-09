package com.xhp.scm.controller;

import com.xhp.scm.entity.Account;
import com.xhp.scm.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by xhp on 2016/9/30.
 */

@Controller
@RequestMapping("/account")
public class AccountAction {

    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/login")
    public ModelAndView login(Account account, HttpServletRequest request, HttpSession session){
        Account acc = accountService.doLogin(account);
         ModelAndView mv = new ModelAndView();
        if(null!=acc){
            //存session
            session.setAttribute("account",acc);
            mv.setViewName("/WEB-INF/main/main.jsp");
            return mv;
//            return "forword:/WEB-INF/main/main.jsp";
        }else{
            request.setAttribute("msg","用户名或密码错误");
             mv.setViewName("/login.jsp");
            return mv;
//            return "forword:/login.jsp";
        }
    }

}
