package com.avinash.parceldelivery.Model;

import java.util.Collection;
import java.util.List;

public class User {
	private String username;
	private String password;
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean credentialsNonExpired;
	private boolean accountNonLocked;
	private List<String> authorities;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public List<String> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + ", accountNonExpired="
				+ accountNonExpired + ", credentialsNonExpired=" + credentialsNonExpired + ", accountNonLocked="
				+ accountNonLocked + ", authorities=" + authorities + "]";
	}
	
	
}
