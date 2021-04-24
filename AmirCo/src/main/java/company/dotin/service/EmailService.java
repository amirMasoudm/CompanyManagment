package company.dotin.service;

import company.dotin.model.Attachment;
import company.dotin.model.Email;
import company.dotin.model.Employe;
import company.dotin.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailRepository repository;
    @Autowired
    private EmployeService employeService;

    public void saveEmaile(Email email) {
        repository.save(email);

    }

    public Email findById(int emailId) {

        return repository.findById(emailId);
    }

    public List<Email> inbox(Employe employe) {
        return repository.employeInboxMail(employe);
    }

    public List<Employe> reciverList(List<String> employes) {
        List<Employe> recivers = new ArrayList<>();
        Employe employe=new Employe();
        for (String employeName : employes) {
           employeName= employeName.replace("{", "");
            employeName= employeName.replace("}", "");
            employe=employeService.findByName(employeName);
            recivers.add(employe);
            System.out.println(employeName);
        }
        return recivers;
    }

}
