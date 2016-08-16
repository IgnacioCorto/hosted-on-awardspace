package com;

public class Cortorreal {
	
	private String 
			datoAlmacenado = "" ,
			datoHobby = "" ;
	
	public Cortorreal() {
		setNombre("Ignacio Padre");
		setHobby ("Domino");
	}
	
	public void setNombre(String dato) {
		datoAlmacenado = dato;
	}
	
	public String getNombre() {
		return datoAlmacenado;
	}

	public void setHobby(String dato) {
		datoHobby = dato;
	}
	
	public String getHobby() {
		return datoHobby;
	}
	
}