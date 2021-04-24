package company.dotin.repository;

import company.dotin.model.Employe;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
public class EmployeRepository implements JPARepository<Employe, Integer> {


    @PersistenceContext
    private EntityManager enitityManager;

    public void save(Employe employe) {
        enitityManager.persist(employe);
    }

    @Override
    public Employe findById(Integer id) {
        return enitityManager.find(Employe.class, id);
    }

    public void update(Employe employe) {
        enitityManager.merge(employe);
    }

    @Override
    public void delete(Employe object) {
        enitityManager.merge(object);
    }

    public List<Employe> findList() {
        return enitityManager.createQuery("select employe from t_employe employe where employe.c_modification_Date_Time is null and not employe.c_name='مدیر'").getResultList();
    }

    @Override
    public Employe findeByname(String name) {
        Query employes = enitityManager.createQuery("select emp from t_employe emp where emp.c_name=:name");
        employes.setParameter("name",name);
        List<Employe> employeList=employes.getResultList();
        Employe employe=new Employe();
        for (Employe fEmploye:employeList) {
            employe=fEmploye;
        }
        return employe;
    }

}
