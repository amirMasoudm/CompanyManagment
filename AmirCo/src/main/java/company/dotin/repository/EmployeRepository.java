package company.dotin.repository;

import company.dotin.model.Employe;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeRepository implements JPARepository<Employe, Integer> {


    @PersistenceContext
    private EntityManager enitityManager;

    @Transactional
    public void save(Employe employe) {
        enitityManager.merge(employe);
    }

    @Override
    public Employe findById(Integer id) {
        return enitityManager.find(Employe.class, id);
    }

    @Transactional
    public void update(Employe employe) {
        enitityManager.merge(employe);
    }
    public List<Employe> findList(){
        return enitityManager.createQuery("select employe from t_employe employe").getResultList();
    }

    @Override
    public Employe findeByname(String name) {
        return null;
    }

}
