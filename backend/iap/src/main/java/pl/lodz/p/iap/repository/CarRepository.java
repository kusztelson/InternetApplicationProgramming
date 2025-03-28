package pl.lodz.p.iap.repository;

import pl.lodz.p.iap.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByName(String name);
    Car findById(long id);
}
