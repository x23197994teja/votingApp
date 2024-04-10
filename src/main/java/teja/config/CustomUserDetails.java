package teja.config;

import java.util.Collection;
import java.util.List;

import teja.model.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetails implements UserDetails {


	private AppUser appUser;
	
	
	public CustomUserDetails(AppUser appUser) {
		this.appUser = appUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

	SimpleGrantedAuthority simpleGrantedAuthority =	new SimpleGrantedAuthority(appUser.getRole());
		
		
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {

		return appUser.getPassword();
	}

	@Override
	public String getUsername() {

		return appUser.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
