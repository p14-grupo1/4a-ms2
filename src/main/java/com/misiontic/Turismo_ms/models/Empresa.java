package com.misiontic.Turismo_ms.models;
import org.springframework.data.annotation.Id;
import java.util.Date;

public class Empresa {
	
	@Id
	private String nit;
	private String gerente;
	private String nameEmp;
	private Integer estrellas;
	private String size;
	
	public Empresa(String nit, String gerente, String nameEmp, Integer estrellas, String size) {
		
		this.nit = nit;
		this.gerente = gerente;
		this.nameEmp = nameEmp;
		this.estrellas = estrellas;
		this.size = size;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getGerente() {
		return gerente;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	public String getNameEmp() {
		return nameEmp;
	}
	public void setNameEmp(String nameEmp) {
		this.nameEmp = nameEmp;
	}
	public Integer getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(Integer estrellas) {
		this.estrellas = estrellas;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
}
