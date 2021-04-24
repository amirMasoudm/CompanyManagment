package company.dotin.service;

import company.dotin.Exceptino.NullObjectException;
import company.dotin.dto.EmployVO;
import company.dotin.model.Employe;
import company.dotin.repository.EmployeRepository;
import company.dotin.repository.JPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepository repository;

    public List<Employe> employeList() {
        return repository.findList();
    }

    public Object update(Employe employe) {
        Employe employeCheck = repository.findById(employe.getId());
        if (employeCheck.getC_version() == employe.getC_version()) {
            repository.update(employe);
            return "اطلاعات کاربر به روز رسانی شد";
        } else return "اطلاعات کاربر تغییر کرده برای دریافت وضعیت جدید دوباره اقدام کنید";
    }

    public void save(Employe employe) {
        repository.save(employe);
    }

    public void generateManager() {
        Employe manager = new Employe();
        manager.setC_name("مدیر");
        repository.save(manager);
    }

    public Employe findOne(Integer id) {
        return repository.findById(id);
    }

    public void remove(Employe employe) {
        employe.setC_activation(true);
        employe.setC_modification_Date_Time(LocalDateTime.now());
        repository.delete(employe);
    }
    public void deactive(Employe employe) {
        employe.setC_activation(true);
        repository.delete(employe);
    }
    public void reactive(Employe employe) {
        employe.setC_activation(false);
        repository.update(employe);
    }
    public Employe findByName(String name) {
        return repository.findeByname(name);
    }
}
