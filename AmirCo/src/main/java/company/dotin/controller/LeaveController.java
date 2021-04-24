package company.dotin.controller;

import company.dotin.Exceptino.OverLapException;
import company.dotin.dto.LeaveVO;
import company.dotin.model.CategoryElement;
import company.dotin.model.Employe;
import company.dotin.model.Leave;
import company.dotin.service.CategoryElementService;
import company.dotin.service.EmployeService;
import company.dotin.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class LeaveController {
    @Autowired
    private LeaveService service;
    @Autowired
    private EmployeService employeService;
    @Autowired
    private CategoryElementService elementService;

    @RequestMapping("/createLeve/{id}")
    public ModelAndView createLeave(@PathVariable("id") int id, @ModelAttribute LeaveVO leaveVO) {
        ModelAndView model;
        Employe employe = employeService.findOne(id);
        LocalDate fromdate = LocalDate.parse(leaveVO.getFromDate());
        LocalDate todate = LocalDate.parse(leaveVO.getToDate());
        Leave leave = new Leave(service.findStatusByName("ارسال به مدیر"), fromdate, todate, employe);
        int overLap = service.checkOverLap(service.findListByEmploye(leave.getC_employe()), leave.getC_fromDate());
        if (0 < overLap) {
            try {
                throw new OverLapException();
            } catch (OverLapException e) {
                model = new ModelAndView("leave/createLeave");
                model.addObject("status", " روز هم پوشانی با درخواست های قبلی دارد" + overLap + "");
                return model;
            }
        } else {
            service.save(leave);
            model = new ModelAndView("employee/EmployePanel");
            model.addObject("employeList", Arrays.asList(employe));
            model.addObject("status", "درخواست با موفقیت ارسال شد");
            return model;
        }
    }

    @RequestMapping("/managerLeaveRequest/{managerId}")
    public ModelAndView managerLeaveRequest(@PathVariable int managerId) {
        ModelAndView model = new ModelAndView("leave/ManagerLeaveRequest");
        List<Leave> leaveList = service.findManagerRequestLeaves(managerId);
        model.addObject("LeaveList", leaveList);
        return model;
    }

    @RequestMapping("/updateLeave/{leaveId}")
    public ModelAndView updateleave(@RequestParam("status") String status, @PathVariable("leaveId") int leaveId) {
        CategoryElement getStatus = service.findStatusByName(status);
        Leave leave = service.findbyId(leaveId);
        leave.setC_status(getStatus);
        service.update(leave);
        System.out.println(leave.getC_status().getC_persianName());
        ModelAndView model = new ModelAndView("leave/ManagerLeaveRequest");
        model.addObject("LeaveList", service.findManagerRequestLeaves(leave.getC_employe().getManager().getId()));
        return model;

    }

    @RequestMapping("/deleteLeave/{leaveId}")
    public ModelAndView deleteLave(@PathVariable("leaveId") int leaveId) {
        ModelAndView model = new ModelAndView("leave/LeaveList");
        Leave leave = service.findbyId(leaveId);
        leave.setC_activation(true);
        service.update(leave);
        model.addObject("myLeaveList", service.findListByEmploye(leave.getC_employe()));
        return model;
    }

    @RequestMapping("/LeaveList/{employeId}")
    public ModelAndView leaveList(@PathVariable("employeId") int emoloyeId) {
        ModelAndView model;
        Employe employe = employeService.findOne(emoloyeId);
        List<Leave> leaveList = service.findListByEmploye(employe);
        if (leaveList.size() > 0) {
            model = new ModelAndView("leave/LeaveList");
            model.addObject("myLeaveList", leaveList);
            return model;
        } else {
            model = new ModelAndView("employee/EmployePanel");
            model.addObject("employeList", Arrays.asList(employe));
            model.addObject("status", "لیست مرخصی ها خالی است");
            return model;
        }
    }

    @RequestMapping("switchToCrateLeave/{id}")
    public ModelAndView change(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("leave/createLeave");
        model.addObject("employe", employeService.findOne(id));
        return model;
    }
}
