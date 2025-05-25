package pl.lodz.p.iap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pl.lodz.p.iap.domain.SyncMessage;
import pl.lodz.p.iap.repository.SyncMessageRepository;

@Service
public class SyncMessageServiceImpl implements SyncMessageService {
    private SyncMessageRepository syncMessageRepository;

    @Autowired
    public SyncMessageServiceImpl(SyncMessageRepository syncMessageRepository) {
        this.syncMessageRepository = syncMessageRepository;
    }

    @Transactional
    public void addSync(SyncMessage syncMessage) {
        syncMessageRepository.save(syncMessage);
    }

    @Transactional
    public void editSync(SyncMessage syncMessage) {        
        syncMessageRepository.save(syncMessage);
    }

    @Transactional
    public List<SyncMessage> listSync() {
        return syncMessageRepository.findAll();
    }

    @Transactional
    public void deleteSync(long id) {
        syncMessageRepository.deleteById(id);
    }

    @Transactional
    public SyncMessage getSync(long id) {
        return syncMessageRepository.findById(id);
    }
}
