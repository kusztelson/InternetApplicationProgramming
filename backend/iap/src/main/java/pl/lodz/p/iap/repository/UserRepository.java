package pl.lodz.p.iap.repository;

import pl.lodz.p.iap.domain.RentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface UserRepository extends JpaRepository<RentUser, Long> {
    List<RentUser> findByName(String name);
    RentUser findOneByLogin(String name);
    RentUser findById(long id);
}
