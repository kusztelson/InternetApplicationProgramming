package pl.lodz.p.iap.service;

import java.util.List;

import pl.lodz.p.iap.domain.User;

public interface UserService {
    public void addUser(User user);
    public void editUser(User user);
    public List<User> listUser();
    public void deleteUser(long id);
    public User getUser(long id);
}
