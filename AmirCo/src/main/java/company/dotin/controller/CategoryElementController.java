package company.dotin.controller;

import antlr.collections.List;
import company.dotin.dto.CategoryElementVO;
import company.dotin.model.Category;
import company.dotin.model.CategoryElement;
import company.dotin.service.CategoryElementService;
import company.dotin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Enumeration;
import java.util.stream.Stream;

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
    public @ResponseBody Object createElement(@RequestBody CategoryElementVO categoryVO) {
        service.creatRole(categoryVO);
        return "نقش سازمانی اضافه شده";
    }

    @RequestMapping("/findOne")
    public @ResponseBody Object findOne(@RequestBody CategoryElementVO categoryElementVO){
        System.out.println("in finde");
        service.findById(categoryElementVO);
        return "ok";
    }
//    @RequestMapping(method = RequestMethod.GET, path = "/createCategoryElement.do")
//    @ResponseBody
//    public String createCategoryElement() {
//        System.out.println("element recived");
////        service.creatRole(element);
//        return "/test.html";
//    }
}
