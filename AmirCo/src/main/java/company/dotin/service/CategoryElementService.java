package company.dotin.service;

import company.dotin.dto.CategoryElementVO;
import company.dotin.model.Category;
import company.dotin.model.CategoryElement;
import company.dotin.repository.CategoryElementRepository;
import company.dotin.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryElementService {
    @Autowired
    private CategoryElementRepository elementRepository;
@Autowired
private CategoryRepository categoryRepository;
    public void creatRole(CategoryElementVO element) {
        Category category=categoryRepository.findeByname("role");
        CategoryElement categoryElement = new CategoryElement(element.getPersianName(),element.getCode(),category);
        elementRepository.save(categoryElement);
    }
    public CategoryElement findById(CategoryElementVO element){
        CategoryElement categoryElement=elementRepository.findById(1);
        return elementRepository.findById(categoryElement.getId());
    }
}
