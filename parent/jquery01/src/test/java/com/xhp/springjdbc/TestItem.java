package com.xhp.springjdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by xhp on 2016/9/27.
 */
public class TestItem {
    @Test
    public void testFindAll(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemDaoImpl itemDao = (ItemDaoImpl) applicationContext.getBean("itemDao");
        List<Item> list = itemDao.findAll();
    }
}
