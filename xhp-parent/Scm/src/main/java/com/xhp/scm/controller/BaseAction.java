package com.xhp.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;


/**
 * Created by xhp on 2016/10/1.
 */

@Controller
@RequestMapping("/base")
public class BaseAction {

    @Resource
    ServletContext application;

    ///base/goURL/supplier/supplierlist.action
    @RequestMapping("/goURL/{folder}/{file}")
    public String goUrl(@PathVariable String folder,@PathVariable String file){

        return "forward:/WEB-INF/"+folder+"/"+file+".jsp";
    }
}
