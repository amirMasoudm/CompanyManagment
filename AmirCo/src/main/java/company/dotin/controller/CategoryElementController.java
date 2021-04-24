package company.dotin.controller;

import company.dotin.dto.CategoryElementVO;
import company.dotin.service.CategoryElementService;
import company.dotin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@Scope("singleton")
@RequestMapping("/CEC")

public class CategoryElementController {

    @Autowired
    private CategoryElementService service;

    @Autowired
    private CategoryService catService;

    @RequestMapping(value = "/createCategoryElement.doo")
    public String test(){
        System.out.println("test passed");
        return "/createCategoryElement.doo";
    }

    @RequestMapping(value = "/createCategoryElement.do",method = RequestMethod.POST)
    public String createElement(@ModelAttribute CategoryElementVO categoryVO) {
        service.creatRole(categoryVO);
        return "employee/employeeManagment";
    }
    @RequestMapping("/findOne")
    public @ResponseBody Object findOne(@RequestBody CategoryElementVO categoryElementVO){
        System.out.println("in finde");
        service.findById(categoryElementVO);
        return "ok";
    }
    @RequestMapping("/testAtt")
    public ModelAndView testAtt(){
        System.out.println("in test");
        ModelAndView ts=new ModelAndView("employee/EmployePanel");
        ArrayList list=new ArrayList();
        list.add("one");
        list.add("two");
        ts.addObject("massage",list);
        return ts;
    }

}
