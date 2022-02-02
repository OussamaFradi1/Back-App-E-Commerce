package formation.ecommerce.Dao;

import formation.ecommerce.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User,Long> {
}
