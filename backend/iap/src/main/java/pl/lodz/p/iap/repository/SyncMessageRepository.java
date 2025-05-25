package pl.lodz.p.iap.repository;

import pl.lodz.p.iap.domain.Reservation;
import pl.lodz.p.iap.domain.SyncMessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.time.LocalDateTime;



@Transactional
@Repository
public interface SyncMessageRepository extends JpaRepository<SyncMessage, Long> {
    List<SyncMessage> findBySyncTimestamp(LocalDateTime syncTimestamp);
    SyncMessage findById(long id);
}
