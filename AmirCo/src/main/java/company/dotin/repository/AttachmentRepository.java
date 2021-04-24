package company.dotin.repository;

import company.dotin.model.Attachment;
import company.dotin.model.Email;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AttachmentRepository implements JPARepository<Attachment, Integer> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Attachment attachment) {
        entityManager.persist(attachment);
    }

    @Override
    public Attachment findById(Integer integer) {
        return entityManager.find(Attachment.class, integer);

    }

    public List<Attachment> findListByEmail(Email email) {
        Query query = entityManager.createQuery("select attch from t_attachment attch where attch.c_email=:email");
        query.setParameter("email", email);
        List<Attachment> attachments=query.getResultList();
        return attachments;
    }

    @Override
    public List<Attachment> findList() {
        return null;
    }

    @Override
    public Attachment findeByname(String name) {
        return null;
    }

    @Override
    public void update(Attachment object) {

    }

    @Override
    public void delete(Attachment object) {

    }
}
