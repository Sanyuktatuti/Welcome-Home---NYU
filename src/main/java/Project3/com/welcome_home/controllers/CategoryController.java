package Project3.com.welcome_home.controllers;

import Project3.com.welcome_home.entities.Category;
import Project3.com.welcome_home.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{mainCategory}/{subCategory}")
    public Optional<Category> getCategory(@PathVariable String mainCategory, @PathVariable String subCategory) {
        return categoryService.getCategory(mainCategory, subCategory);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/{mainCategory}/{subCategory}")
    public void deleteCategory(@PathVariable String mainCategory, @PathVariable String subCategory) {
        categoryService.deleteCategory(mainCategory, subCategory);
    }
}
