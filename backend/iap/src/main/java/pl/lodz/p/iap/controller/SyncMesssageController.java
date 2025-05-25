package pl.lodz.p.iap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import pl.lodz.p.iap.domain.SyncMessage;
import pl.lodz.p.iap.domain.SyncMessageDTO;
import pl.lodz.p.iap.repository.SyncMessageRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class SyncMesssageController {
    private SyncMessageRepository syncMessageRepository;

    @Autowired
    public SyncMesssageController(SyncMessageRepository syncMessageRepository) {
        this.syncMessageRepository = syncMessageRepository;
    }

    @GetMapping("/syncMessages")
    public List<SyncMessageDTO> getSyncMessages() {
        List<SyncMessage> allMessages = syncMessageRepository.findAll();
        List<SyncMessageDTO> DTOMessages = new ArrayList<>();
        for(SyncMessage message : allMessages) {
            DTOMessages.add(new SyncMessageDTO(message));
        }
        return DTOMessages;
    }
}
