package com.xhp.scm.controller;

import com.xhp.scm.entity.Page;
import com.xhp.scm.entity.Supplier;
import com.xhp.scm.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhp on 2016/9/30.
 */
@Controller
@RequestMapping("/supplier")
public class SupplierAction {
    @Resource
    private SupplierService supplierService;

    @RequestMapping(value = "/insert")
    @ResponseBody
    public Object insert(Supplier supplier){
        int i = 0;
        try{
            i = supplierService.insert(supplier);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping("/deleteList")
    @ResponseBody
    public Object deletelist(String[] pks){
        int i = 0;
        try {
            i = supplierService.deleteList(pks);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping("/selectSupplier")
    @ResponseBody
    public Object selectSupplier(String start,String end){
        System.out.println("start:"+ start+"||end:"+end);
        Map<String, String> paramMap =new HashMap<String, String>();
        paramMap.put("start", start);
        paramMap.put("end", end);

        return supplierService.selectSupplier(paramMap);
    }

    //通过关键字分页
    @RequestMapping("/selectPage")
    @ResponseBody
    public Object selectPage(Page<Supplier> page){
        Page p = supplierService.selectPage(page);
        Map<String, Object> pageMap = page.getPageMap();
        return page.getPageMap();
    }
    //通过关键字分页查询,多条件查询
    @RequestMapping("/selectPageUseDyc")
    @ResponseBody
    public Object selectPageUseDyc(Page<Supplier> page,Supplier supplier){
        page.setParamEntity(supplier);
        Page p = supplierService.selectPageUseDyc(page);
        return p.getPageMap();
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object updatePage(Supplier supplier){
        int i = 0;
        try {
            i = supplierService.update(supplier);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /*// 通过关键字分页查询
    @RequestMapping("/selectPage")
    @ResponseBody
    public Object selectPage(Page<Supplier> page, HttpServletRequest request){
        String pageIndex = request.getParameter("page");    //easyui里面定义的哦
        String pagSize = request.getParameter("rows");
        String keyWords = request.getParameter("keyWord");

        page.setKeyWord(keyWords);
        Page p = supplierService.selectPage(page);
        System.out.print(p);
        Map<String,Object> map = new HashMap<>();
        map.put("total",page.getTotalRecord());
        map.put("rows",page.getList());
        return map;
    }*/
}
