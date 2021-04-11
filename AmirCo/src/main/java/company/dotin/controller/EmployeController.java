package company.dotin.controller;

import company.dotin.dto.EmployVO;
import company.dotin.model.CategoryElement;
import company.dotin.model.Employe;
import company.dotin.repository.CategoryElementRepository;
import company.dotin.service.CategoryElementService;
import company.dotin.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeController {
    @Autowired
    private EmployeService service;
    @Autowired
    private CategoryElementRepository categoryElementRepository;

    @RequestMapping(value = "/creatEmploye", method = RequestMethod.POST)
    public @ResponseBody
    Object creatEmploye(@RequestBody EmployVO employVO) {
        Employe manager = service.findOne(employVO.getManagerId());
        CategoryElement role = categoryElementRepository.findById(employVO.getRoleId());
        if (role == null) {
            return "کد نقش وارد شده صحیح نیست";
        } else if (employVO.getManagerId() != 0 && manager == null) {
            System.out.println("man id null");
            return "کد مدیر وارد شده صحیح نیست";
        }
        Employe employe = new Employe(employVO.getName(), employVO.getFamily(), manager, role);
        service.save(employe);
        return "کاربر با موفقیت اضافه شد";
    }

    @RequestMapping(value = "/findEmployee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object updateEmploye(@RequestParam("id") int id) {
        return service.findOne(id);
    }
    @RequestMapping(value = "/updateEmploye")
    public @ResponseBody
    Object updateEmployee(@RequestBody EmployVO employVO) {
        Employe manager = service.findOne(employVO.getManagerId());
        CategoryElement role = categoryElementRepository.findById(employVO.getRoleId());
        if (role == null) {
            return "کد نقش وارد شده صحیح نیست";
        } else if (employVO.getManagerId() != 0 && manager == null) {
            System.out.println("man id null");
            return "کد مدیر وارد شده صحیح نیست";
        }
        Employe employe = new Employe(employVO.getId(),employVO.getName(), employVO.getFamily(), manager, role);
        employe.setC_version(employVO.getVersion());
        service.update(employe);
        return "اطلاعات کاربر به روز رسانی شد";
    }
    @RequestMapping("/employeList")
    public @ResponseBody Object employeList(){
        return service.employeList();
    }

}
