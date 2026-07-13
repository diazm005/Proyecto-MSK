package com.dsw2.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String rol;
	
	public Usuario() {}
	
	public Usuario(int id, String username, String password, String rol) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.rol= rol;
	}
	
	public int getId() { return id;}
	public String getUsername() {return username;}
	public String getPassword() {return password;}
	public String getRol() {return rol;}
	
	public void setId(int id) {this.id=id;}
	public void setUsername(String username) {this.username=username;}
	public void setPassword(String password) {this.password=password;}
	public void setRol(String rol) {this.rol=rol;}
	
	

}
