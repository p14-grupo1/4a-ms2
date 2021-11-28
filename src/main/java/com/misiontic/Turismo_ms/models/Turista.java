package com.misiontic.Turismo_ms.models;
import java.util.Date;
import org.springframework.data.annotation.Id;

public class Turista {
	
	@Id
	private String username;
	private String nombreLugar;
	private Integer age;
	private Date lastChange;
	
	
	public Turista(String username, String nombreLugar, Integer age, Date lastChange) {
		this.username = username;
		this.nombreLugar = nombreLugar;
		this.age = age;
		this.lastChange = lastChange;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getLastChange() {
		return lastChange;
	}
	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}

	public String getNombreLugar() {
		return nombreLugar;
	}

	public void setNombreLugar(String nombreLugar) {
		this.nombreLugar = nombreLugar;
	}
}
