package pl.lodz.p.iap.repository;

import pl.lodz.p.iap.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByName(String name);
    Reservation findById(long id);
}
