package pl.lodz.p.iap.service;

import java.util.List;

import pl.lodz.p.iap.domain.SyncMessage;

public interface SyncMessageService {
    public void addSync(SyncMessage syncMessage);
    public void editSync(SyncMessage syncMessage);
    public List<SyncMessage> listSync();
    public void deleteSync(long id);
    public SyncMessage getSync(long id);
}
