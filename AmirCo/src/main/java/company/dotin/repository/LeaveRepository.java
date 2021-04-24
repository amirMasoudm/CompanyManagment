package company.dotin.repository;

import company.dotin.model.Employe;
import company.dotin.model.Leave;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class LeaveRepository implements JPARepository<Leave, Integer> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Leave leave) {
        entityManager.persist(leave);
    }

    @Override
    public Leave findById(Integer integer) {
        return entityManager.find(Leave.class, integer);
    }

    public List<Leave> findListByEmploye(Employe employe) {
        Query query = entityManager.createQuery("select leave from t_leave leave where leave.c_employe_id=:employe and leave.c_activation=false ");
        query.setParameter("employe", employe);
        List<Leave> leaves = query.getResultList();
        return leaves;
    }

    public List<Leave> findManagerRequestLeaves(int managerId) {
        Query query = entityManager.createQuery("select leave from t_leave leave where leave.c_employe_id.manager.id=:managerId");
        query.setParameter("managerId", managerId);
        List<Leave> managerRequestLeaves = query.getResultList();
        return managerRequestLeaves;
    }

    public Leave findByEmploye(Employe employe) {
        Query query = entityManager.createQuery("select leave from t_leave leave where leave.c_employe_id=:employe");
        query.setParameter("employe",employe);
        List<Leave> employes=query.getResultList();
        return employes.get(0);
    }

    @Override
    public List<Leave> findList() {
        return entityManager.createQuery("select leave from t_leave leave").getResultList();
    }

    @Override
    public Leave findeByname(String name) {
        return null;
    }

    @Override
    public void update(Leave object) {
        entityManager.merge(object);
    }

    @Override
    public void delete(Leave object) {

    }
}
