package com.misiontic.Turismo_ms.models;
import org.springframework.data.annotation.Id;
import java.util.Date;

public class Hotel {
    
	@Id
    private String id;
	private String owner; 
    private String viceowner;
    private String type;
    private Integer qualification;
    private Date date;
    
    
	public Hotel(String id, String owner, String viceowner, String type, Integer qualification, Date date) {
		this.id = id;
		this.owner = owner;
		this.viceowner = viceowner;
		this.type = type;
		this.qualification = qualification;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getViceowner() {
		return viceowner;
	}
	public void setViceowner(String viceowner) {
		this.viceowner = viceowner;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getQualification() {
		return qualification;
	}
	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    
	
	
}
