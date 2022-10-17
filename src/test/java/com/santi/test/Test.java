package com.santi.test;

import com.santi.pojo.Free;
import com.santi.serivce.FreeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {

//    private FreeService freeDao;
    @org.junit.Test
    public void before(){
        ApplicationContext app=new ClassPathXmlApplicationContext("spring.xml");
        FreeService bean = app.getBean(FreeService.class);
        int i = bean.addFreePid(2);
        Free id = bean.getNewId();

        int i1 = bean.updateTitle("东谷", id.getId());
        System.out.println(i1);
    }
}
