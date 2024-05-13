package com.security.model;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.multiDB.a.entity.AppUser;

@SuppressWarnings("serial")
public class AppUserDetails implements UserDetails {
	
	private final AppUser appUser;

    public AppUserDetails(AppUser user) {
        this.appUser = user;
    }

    // 必須覆寫的方法
    public String getUsername() { return appUser.getEmail(); }
    public String getPassword() { return appUser.getPassword(); }
    public boolean isEnabled() { return appUser.isEnabled(); }
    public boolean isAccountNonLocked() { return true; }
    public boolean isCredentialsNonExpired() { return true; }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(appUser.getAuthority());
    }

    public boolean isAccountNonExpired() {
        if (appUser.getTrailExpiration() == null) {
            return true;
        }

        return LocalDate.now().isBefore(appUser.getTrailExpiration());
    }
    
    // 自定義的 public 方法
    public String getId() { return appUser.getId(); }
    public UserAuthority getUserAuthority() { return appUser.getAuthority(); }
    public boolean isPremium() { return appUser.isPremium(); }
    public LocalDate getTrailExpiration() { return appUser.getTrailExpiration(); }

}