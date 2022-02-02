package formation.ecommerce.Dao;

import formation.ecommerce.Models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface subcategoryRepository extends JpaRepository<SubCategory,Long> {
}
