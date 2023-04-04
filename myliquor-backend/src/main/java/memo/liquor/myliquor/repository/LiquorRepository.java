package memo.liquor.myliquor.repository;

import memo.liquor.myliquor.entity.Liquor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LiquorRepository extends JpaRepository<Liquor, Long> {
  @Query("select l from Liquor l join fetch l.category")
  List<Liquor> findAllLiquor();
}
