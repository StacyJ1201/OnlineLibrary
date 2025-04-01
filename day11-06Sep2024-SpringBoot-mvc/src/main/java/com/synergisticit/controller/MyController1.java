package com.synergisticit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController1 {
    //MVC design pattern: Model, Controller, View
    //Spring's Front Controller: DispatcherServlet
    //Request goes to DispatcherServlet and response comes out from DispatcherServlet

    @RequestMapping("m1")
    public void m1(){
        System.out.println("m1()......");
    }

    @RequestMapping("m2")
    public void m2(){
        System.out.println("m2()......");
    }

    @RequestMapping("name")
        public ResponseEntity<String> showName(){
            String name = "Stacy";
            System.out.println("showName()..... "+name);
            return new ResponseEntity<String>(name, HttpStatus.OK);
    }

    //since this method is not mapped to any request String (@RequestMapping("name")) This method is never executed
    public ResponseEntity<String> printsChristopher(){
        String name = "Christopher";
        System.out.println("showName()..... "+name);
        return new ResponseEntity<String>(name, HttpStatus.OK);
    }

}
