package company.dotin.repository;

import company.dotin.model.Attachment;
import company.dotin.model.Email;
import company.dotin.model.Employe;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;

@Repository
public class EmailRepository implements JPARepository<Email, Integer> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Email email) {
        entityManager.persist(email);
    }


    @Override
    public Email findById(Integer integer) {

        return entityManager.find(Email.class, integer);
    }

    public List<Email> employeInboxMail(Employe employe) {
        Query query = entityManager.createQuery("select employe.emailList from t_employe employe where employe.id=:empId");
        query.setParameter("empId", employe.getId());
        List<Email> inbox = query.getResultList();
        System.out.println(inbox.size());
        return inbox;
    }


    @Override
    public List<Email> findList() {
        return null;
    }

    @Override
    public Email findeByname(String name) {
        return null;
    }

    @Override
    public void update(Email object) {

    }

    @Override
    public void delete(Email object) {

    }
}
