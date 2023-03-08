package memo.liquor.myliquor.repository;

import memo.liquor.myliquor.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
