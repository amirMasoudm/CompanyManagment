package company.dotin.service;

import company.dotin.model.Category;
import company.dotin.model.Employe;
import company.dotin.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public void saveCategory(Category category) {
        repository.save(category);
    }

    public Category findById(int id) {
        return repository.findById(id);
    }

    public void checkCategory() {
        if (repository.findList().size() != 2) {
            Category role = new Category();
            Category leaveStatus = new Category();
            role.setC_name("role");
            leaveStatus.setC_name("status");
            saveCategory(role);
            saveCategory(leaveStatus);
        }
    }

    public Category findByName(String name) {
        return repository.findeByname(name);
    }
}
