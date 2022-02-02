package formation.ecommerce.Dao;

import formation.ecommerce.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderRepository extends JpaRepository<Order,Long> {
}
