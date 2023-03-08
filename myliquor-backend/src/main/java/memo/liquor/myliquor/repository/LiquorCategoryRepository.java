package memo.liquor.myliquor.repository;

import memo.liquor.myliquor.entity.LiquorCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiquorCategoryRepository extends JpaRepository<LiquorCategory, Long> {
}
