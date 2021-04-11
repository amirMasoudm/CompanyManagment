package company.dotin.repository;

import company.dotin.model.CategoryElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryElementRepository implements JPARepository<CategoryElement, Integer> {

    @PersistenceContext
    private EntityManager enitityManager;
    @Transactional
    @Override
    public void save(CategoryElement categoryElement) {
        enitityManager.persist(categoryElement);
    }

    @Override
    public CategoryElement findById(Integer id) {
        return enitityManager.find(CategoryElement.class, id);
    }

    public List<CategoryElement> findList() {
        List<CategoryElement> categoryElementList = enitityManager.createQuery("select element from t_categoryElement element").getResultList();
        return categoryElementList;
    }

    public CategoryElement findeByname(String name) {
        List<CategoryElement> categoryElementList = findList();
        for (CategoryElement element : categoryElementList) {
            if (element.getC_persianName().equals(name)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public void update(CategoryElement categoryElement) {
        enitityManager.merge(categoryElement);
    }
}
