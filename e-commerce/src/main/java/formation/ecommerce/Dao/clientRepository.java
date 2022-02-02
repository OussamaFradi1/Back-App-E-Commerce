package formation.ecommerce.Dao;

import formation.ecommerce.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientRepository extends JpaRepository<Client,Long> {
}
