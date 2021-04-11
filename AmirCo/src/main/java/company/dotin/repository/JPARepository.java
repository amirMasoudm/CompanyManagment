package company.dotin.repository;

import company.dotin.model.Category;
import company.dotin.model.CategoryElement;
import company.dotin.model.Employe;

import java.util.List;

public interface JPARepository <Model, Id>  {
    public void save(Model model);

    public Model findById(Id id);

    public List<Model> findList();
    public Model findeByname(String name);
    public void update(Model object);
}