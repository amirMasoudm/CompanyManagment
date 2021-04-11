package company.dotin.repository;

import company.dotin.model.Category;
import company.dotin.model.CategoryElement;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryRepository implements JPARepository<Category,Integer> {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Category category) {
        entityManager.persist(category);
    }

    public Category findById(Integer id) {
        System.out.println(entityManager.find(Category.class, id).getC_name());
        return entityManager.find(Category.class, id);
    }
    public Category findeByname(String name) {
        List<Category> categoryElementList = findList();
        for (Category element : categoryElementList) {
            if (element.getC_name().equals(name)) {
                System.out.println("finde rolee"+element.getId());
                return element;
            }
        }
        return null;
    }

    @Override
    public void update(Category category) {
        entityManager.merge(category);
    }

    public List<Category> findList() {
        return entityManager.createQuery("select category from t_category category").getResultList();

    }

}
