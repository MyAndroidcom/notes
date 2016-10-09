package com.xhp.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/dept")
public class DeptAction {


    @RequestMapping(value = "/insert")
    public String insert(){
            return null;
    }
}
