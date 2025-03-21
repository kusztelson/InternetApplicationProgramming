package pl.lodz.p.iap.repository;

import pl.lodz.p.iap.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
    User findById(long id);
}
