package company.dotin.controller;

import company.dotin.Exceptino.NullObjectException;
import company.dotin.Exceptino.VersionException;
import company.dotin.dto.EmployVO;
import company.dotin.model.CategoryElement;
import company.dotin.model.Employe;
import company.dotin.repository.CategoryElementRepository;
import company.dotin.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class EmployeController {
    @Autowired
    private EmployeService service;
    @Autowired
    private CategoryElementRepository categoryElementRepository;

    @RequestMapping("/swichToEmployeManagment")
    public String swich() {
        return "employee/employeeManagment";
    }

    @RequestMapping(value = "/creatEmploye", method = RequestMethod.POST)
    public ModelAndView creatEmploye(@ModelAttribute EmployVO employVO) {
        ModelAndView model = new ModelAndView("employee/employeeManagment");
        Employe manager = service.findByName(employVO.getManagerName());
        CategoryElement role = categoryElementRepository.findeByname(employVO.getRoleName());
        try {
            if (role.getC_persianName() == null) {
            }
        } catch (Exception e) {
            model.addObject("status", "کد نقش وارد شده صحیح نیست");
            return model;
        }
        if (!employVO.getManagerName().equals("مدیر") && manager.getC_name() == null) {
            try {
                throw new NullObjectException();
            } catch (NullObjectException e) {
                model.addObject("status", "کد مدیر وارد شده صحیح نیست");
                return model;
            }
        }
        Employe employe = new Employe(employVO.getName(), employVO.getFamily(), manager, role);
        service.save(employe);
        model.addObject("status", "کاربر باموفقیت اضافه شد");
        return model;
    }

    @RequestMapping(value = "/findEmployee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView findEmploye(@RequestParam("name") String name, HttpServletRequest request) {
        ModelAndView model;
        String referer=request.getHeader("referer");
        switch (referer) {
            case "http://localhost:8080/":
                model = new ModelAndView("employee/EmployePanel");
                break;
            default:
                model = new ModelAndView("employee/employeList");
        }
        Employe employe = service.findByName(name);
        if (employe.getC_name() != null) {
            model.addObject("employeList", Arrays.asList(employe));
            return model;
        } else {
            try {
                throw new NullObjectException();
            } catch (NullObjectException e) {
                model = new ModelAndView("employee/employeeManagment");
                model.addObject("status", "نام اشتباه است");
                return model;
            }
        }
    }

    @RequestMapping(value = "/updateEmploye/{empId}/{version}")
    public ModelAndView updateEmployee(@ModelAttribute EmployVO employVO, @PathVariable("empId") int empId, @PathVariable("version") int version) {
        ModelAndView model = new ModelAndView("employee/employeList");
        Employe manager = service.findByName(employVO.getManagerName());
        CategoryElement role = categoryElementRepository.findeByname(employVO.getRoleName());
        try {
            if (role.getC_persianName() == null) {
            }
        } catch (Exception e) {
            model.addObject("status", "نام نقش وارد شده صحیح نیست");
            return model;
        }
        if (!employVO.getManagerName().equals("مدیر") && manager.getC_name() == null) {
            try {
                throw new NullObjectException();
            } catch (NullObjectException e) {
                model.addObject("status", "نام مدیر وارد شده صحیح نیست");
                return model;
            }
        } else {
            Employe employe = new Employe(empId, employVO.getName(), employVO.getFamily(), manager, role);
            employe.setC_version(version);
            service.update(employe);
            model.addObject("employeList", service.employeList());
            return model;
        }
    }

    @RequestMapping("/employeList")
    public ModelAndView employeList() {
        ModelAndView model = new ModelAndView("employee/employeList");
        model.addObject("employeList", service.employeList());
        return model;
    }

    @RequestMapping("/deleteEmploye/{id}/{version}")
    public ModelAndView deleteEmploye(@PathVariable("id") int id, @PathVariable("version") int version) {
        ModelAndView model = new ModelAndView("employee/employeList");
        Employe employe = service.findOne(id);

        if (employe.getC_version() != version) {
            try {
                throw new VersionException();

            } catch (VersionException e) {
                model.addObject("employeList", service.employeList());
                model.addObject("status", "وضعیت کاربر تغییر کرده دوباره تلاش کنید");
                return model;
            }
        }
        service.remove(employe);
        model.addObject("employeList", service.employeList());
        model.addObject("status", "کاربر حذف شد");
        return model;
    }

    @RequestMapping("/deactive/{id}/{version}")
    public ModelAndView deactive(@PathVariable("id") int id, @PathVariable("version") int version) {
        ModelAndView model = new ModelAndView("employee/employeList");
        Employe employe = service.findOne(id);
        if (employe.getC_version() != version) {
            try {
                throw new VersionException();

            } catch (VersionException e) {
                model.addObject("employeList", service.employeList());
                model.addObject("status", "وضعیت کاربر تغییر کرده دوباره تلاش کنید");
                return model;
            }
        }else {
            service.deactive(employe);
            model.addObject("employeList", service.employeList());
            model.addObject("status", "کاربر غیرفعال شد");
            return model;
        }
    }

    @RequestMapping("/reactive/{version}/{id}")
    public ModelAndView reactive(@PathVariable("id") int id, @PathVariable("version") int version) {
        ModelAndView model = new ModelAndView("employee/employeList");
        Employe employe = service.findOne(id);
        if (employe.getC_version() != version) {
            try {
                throw new VersionException();

            } catch (VersionException e) {
                model.addObject("employeList", service.employeList());
                model.addObject("status", "وضعیت کاربر تغییر کرده دوباره تلاش کنید");
                return model;
            }
        }else {
            service.reactive(employe);
            model.addObject("employeList", service.employeList());
            model.addObject("status", "کاربر فعال شد");
            return model;
        }
    }

}
