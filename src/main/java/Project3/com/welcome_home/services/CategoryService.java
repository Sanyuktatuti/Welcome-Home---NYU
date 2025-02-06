package Project3.com.welcome_home.services;

import Project3.com.welcome_home.entities.Category;
import Project3.com.welcome_home.entities.CategoryId;
import Project3.com.welcome_home.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategory(String mainCategory, String subCategory) {
        // Create CategoryId object
        CategoryId id = new CategoryId(mainCategory, subCategory);
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(String mainCategory, String subCategory) {
        // Create CategoryId object
        CategoryId id = new CategoryId(mainCategory, subCategory);
        categoryRepository.deleteById(id);
    }
}
