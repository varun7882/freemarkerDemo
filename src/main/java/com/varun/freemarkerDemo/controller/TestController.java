package com.varun.freemarkerDemo.controller;

import com.varun.freemarkerDemo.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
public class TestController {

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        Car car= new Car();
        car.setBrand("Suzuki");
        car.setModel("SX4");
        return "welcome";
    }

    @GetMapping(value = "/details")
    public ModelAndView details(){
        Car car= new Car();
        car.setBrand("Suzuki");
        car.setModel("SX4");
        Map params= new HashMap<String,Object>();
        params.put("car",car);
        ModelAndView modelAndView= new ModelAndView("details",params);
        return modelAndView;
    }
}
