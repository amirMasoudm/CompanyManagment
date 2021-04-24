package company.dotin.controller;

import company.dotin.dto.EmailVO;
import company.dotin.model.Attachment;
import company.dotin.model.Email;
import company.dotin.model.Employe;
import company.dotin.service.AttachmentService;
import company.dotin.service.EmailService;
import company.dotin.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private EmailService service;
    @Autowired
    private EmployeService employeService;
    @Autowired
    private AttachmentService attachmentService;

    @RequestMapping("/switchTodendMail/{empId}")
    public ModelAndView swichToSendEmail(@PathVariable("empId") int empId) {
        ModelAndView model = new ModelAndView("email/sendEmail");
        List<Employe> employeList = employeService.employeList();
        employeList.set(0, employeService.findOne(empId));
        model.addObject("employeList", employeList);
        return model;
    }

    @RequestMapping("/switchToEmailPanel/{empId}")
    public ModelAndView swichToEmailPanel(@PathVariable("empId") int empId) {
        ModelAndView model = new ModelAndView("email/EmailPanel");
        model.addObject("employe", employeService.findOne(empId));
        return model;
    }

    @RequestMapping("/createEmail/{reciverNames}")
    public ModelAndView createEmail(@ModelAttribute EmailVO emailVO, @RequestParam("attachmentFile") MultipartFile attachmentFile, @PathVariable("reciverNames") List<String> reciverNames) {
        ModelAndView model = new ModelAndView("email/sendEmail");
        List<Employe> recivers = service.reciverList(reciverNames);
        Employe sernder = employeService.findByName(emailVO.getEmployeName());
        System.err.println(emailVO.getContent()+"dd");
        Email email = new Email(emailVO.getSubject(), sernder, recivers, emailVO.getContent());
        service.saveEmaile(email);
        try {
            Attachment attachment = attachment = new Attachment(attachmentFile.getOriginalFilename(), attachmentFile.getContentType(), attachmentFile.getBytes(), email);
            attachmentService.saveAttachment(attachment);
        } catch (IOException e) {
            model.addObject("status", "فایل مشکل دارد");
            return model;
        }

        System.out.println(sernder.getC_family() + attachmentFile.getContentType());
        List<Employe> employeList = employeService.employeList();
        employeList.set(0, employeService.findByName(emailVO.getEmployeName()));
        model.addObject("employeList", employeList);
        return model;
    }

    @RequestMapping("/inbox/{empId}")
    public ModelAndView employeInbox(@PathVariable("empId") int empId) {
        Employe employe = employeService.findOne(empId);
        List<Email> inbox = service.inbox(employe);
        ModelAndView model = new ModelAndView("email/inbox");
        model.addObject("inbox", inbox);
        return model;
    }

    @RequestMapping("/openEmaile/{emailId}")
    public ModelAndView findEmaile(@PathVariable("emailId") int emailId) {
        System.err.println("in find");
        ModelAndView model = new ModelAndView("email/inbox");
        Email email = service.findById(emailId);
        model.addObject("email", email);
        model.addObject("attachments", attachmentService.EmailAttachments(email));
        return model;
    }
}
