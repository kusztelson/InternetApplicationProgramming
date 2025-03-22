package pl.lodz.p.iap.service;

import java.util.List;

import pl.lodz.p.iap.domain.RentUser;

public interface UserService {
    public void addUser(RentUser user);
    public void editUser(RentUser user);
    public List<RentUser> listUser();
    public void deleteUser(long id);
    public RentUser getUser(long id);
}
