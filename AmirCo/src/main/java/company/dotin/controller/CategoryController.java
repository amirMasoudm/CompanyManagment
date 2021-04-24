package company.dotin.controller;

import company.dotin.model.Employe;
import company.dotin.service.CategoryElementService;
import company.dotin.service.CategoryService;
import company.dotin.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService service;
    @Autowired
    private CategoryElementService elementService;
    @Autowired
    private EmployeService employeService;
    @RequestMapping("/")
    public String homPage() {
        service.checkCategory();
        elementService.generateSomeRoles();
        elementService.generateSomeStatus();
        employeService.generateManager();
        return "wellcom";
    }

}
