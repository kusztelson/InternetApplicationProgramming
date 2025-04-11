package pl.lodz.p.iap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pl.lodz.p.iap.domain.RentUser;
import pl.lodz.p.iap.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void addUser(RentUser user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void editUser(RentUser user) {
        userRepository.save(user);
    }

    @Transactional
    public RentUser getUser(long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public List<RentUser> listUser() {
        return userRepository.findAll();
    }

    @Override
    public RentUser getUserByLogin(String login) {
        return this.userRepository.findOneByLogin(login);
    }
}
