package com.test.clase.demo.controller;


import com.test.clase.demo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/dice")
public class HelloWebController {


    @GetMapping(value = "/helloView")
    public String helloWorldW(Model model){

        model.addAttribute("people",getPeople());
        model.addAttribute("ejemplo","Soy un ejemplo");
        model.addAttribute("ejemplo2",new Date());

        return "hello";
    }
    @GetMapping(value = "/helloMAV")
    public ModelAndView exampleMAV(){

        ModelAndView modelAndView=new ModelAndView("hello");
        modelAndView.addObject("people",getPeople());
        modelAndView.addObject("ejemplo","Soy ejemplo MAV");
        return modelAndView;
    }


    private List<Person> getPeople(){

        List<Person> people =new ArrayList<>();
        people.add(new Person("Jaime",23));
        people.add(new Person("Rugal",24));
        people.add(new Person("Shingi",25));
        people.add(new Person("Chris",26));
        people.add(new Person("Ancelmo",27));
        people.add(new Person("Angus",128));

        return people;
    }
}
