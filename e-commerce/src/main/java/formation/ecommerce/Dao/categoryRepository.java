package formation.ecommerce.Dao;

import formation.ecommerce.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepository extends JpaRepository<Category,Long> {
}
