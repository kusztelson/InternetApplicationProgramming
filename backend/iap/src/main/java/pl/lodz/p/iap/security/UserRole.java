package pl.lodz.p.iap.security;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserRole implements GrantedAuthority {
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
    
}
