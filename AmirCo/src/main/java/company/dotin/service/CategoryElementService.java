package company.dotin.service;

import company.dotin.dto.CategoryElementVO;
import company.dotin.model.Category;
import company.dotin.model.CategoryElement;
import company.dotin.model.Employe;
import company.dotin.repository.CategoryElementRepository;
import company.dotin.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryElementService {
    @Autowired
    private CategoryElementRepository elementRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public void creatRole(CategoryElementVO element) {
        Category category = categoryRepository.findeByname("role");
        CategoryElement categoryElement = new CategoryElement(element.getPersianName(), element.getCode(), category);
        elementRepository.save(categoryElement);
    }

    public List<CategoryElement> findList() {
        return elementRepository.findList();
    }

    public void generateSomeRoles() {
        Category category = categoryRepository.findeByname("role");
        System.out.println("in generate");
        if (findList().size() < 2) {
            System.out.println("in if genaret");
            CategoryElement developer = new CategoryElement("توسعه دهنده", 10, category);
            developer.setId(1);
            CategoryElement hr = new CategoryElement("کارشناس منابع انسانی", 20, category);
            hr.setId(2);
            elementRepository.update(developer);
            elementRepository.update(hr);
        }
    }

    public void generateSomeStatus() {
        Category category = categoryRepository.findeByname("status");
        System.out.println("in generate");
        if (findList().size() < 6) {
            System.out.println("in if genaret status");
            elementRepository.update( new CategoryElement(10,"تایید شده", 60, category));
            elementRepository.update( new CategoryElement(20,"تایید نشده", 70, category));
            elementRepository.update(new CategoryElement(30,"درحال بررسی", 70, category));
            elementRepository.update(new CategoryElement(40,"ارسال به مدیر", 70, category));

        }
    }
    public CategoryElement findById(CategoryElementVO element) {
        CategoryElement categoryElement = elementRepository.findById(1);
        return elementRepository.findById(categoryElement.getId());
    }
}
