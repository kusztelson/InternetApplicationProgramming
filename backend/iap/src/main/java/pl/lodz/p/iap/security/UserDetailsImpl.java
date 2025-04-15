package pl.lodz.p.iap.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import pl.lodz.p.iap.domain.RentUser;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private RentUser user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new UserRole(user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }
    
}
