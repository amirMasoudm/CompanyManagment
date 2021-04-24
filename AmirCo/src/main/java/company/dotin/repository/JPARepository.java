package company.dotin.repository;

import company.dotin.model.Category;
import company.dotin.model.CategoryElement;
import company.dotin.model.Employe;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JPARepository <Model, Id>  {
    @Transactional
    public void save(Model model);

    public Model findById(Id id);

    public List<Model> findList();

    public Model findeByname(String name);
    @Transactional
    public void update(Model object);
    @Transactional
    public void delete(Model object);

}