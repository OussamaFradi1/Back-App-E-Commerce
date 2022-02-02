package formation.ecommerce.Dao;

import formation.ecommerce.Models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface providerRepository extends JpaRepository<Provider,Long> {
}
