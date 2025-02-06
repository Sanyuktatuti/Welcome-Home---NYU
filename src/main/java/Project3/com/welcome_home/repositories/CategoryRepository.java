package Project3.com.welcome_home.repositories;

import Project3.com.welcome_home.entities.Category;
import Project3.com.welcome_home.entities.CategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, CategoryId> {
    Optional<Category> findByMainCategoryAndSubCategory(String mainCategory, String subCategory);
}
