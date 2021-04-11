package company.dotin.controller;

import company.dotin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService service;
    @RequestMapping("/")
    public String homPage() {
        service.checkCategory();
        System.out.println("welcom");
        return "wellcooom";
    }
}
