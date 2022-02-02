package formation.ecommerce.Dao;

import formation.ecommerce.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<Product,Long> {
}
