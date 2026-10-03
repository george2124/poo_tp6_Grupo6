package ar.edu.unju.poo.punto2.model;

public class Titulo {
	private String nombreCarrera;
	private String nivel;
	private int anio;
	
	
	public Titulo(String nombreCarrera, String nivel, int anio) {
		this.nombreCarrera = nombreCarrera;
		this.nivel = nivel;
		this.anio = anio;
	}
	
	public String getNombreCarrera() {
		return nombreCarrera;
	}
}
