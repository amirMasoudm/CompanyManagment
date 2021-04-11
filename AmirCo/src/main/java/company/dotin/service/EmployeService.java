package company.dotin.service;

import company.dotin.dto.EmployVO;
import company.dotin.model.Employe;
import company.dotin.repository.EmployeRepository;
import company.dotin.repository.JPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepository repository;

    //    public void sav
    public List<Employe> employeList() {
        return repository.findList();
    }

    public Object update(Employe employe) {
        Employe employeCheck = repository.findById(employe.getId());
        if (employeCheck.getC_version() == employe.getC_version()) {
            repository.update(employe);
            return "update done";
        } else return "اطلاعات کاربر تغییر کرده برای دریافت وضعیت جدید دوباره اقدام کنید";
    }

    public void save(Employe employe) {
        repository.save(employe);
    }

    public Employe findOne(Integer id) {

        return repository.findById(id);
    }
}
