package memo.liquor.myliquor.repository;

import memo.liquor.myliquor.entity.Liquor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiquorRepository extends JpaRepository<Liquor, Long> {
}
