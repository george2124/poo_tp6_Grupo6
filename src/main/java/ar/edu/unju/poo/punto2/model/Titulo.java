package ar.edu.unju.poo.punto2.model;

public class Titulo {
	private String nombreCarrera;
	private String nivel;
	private int anio;
	
	
	public Titulo(String nombreCarrera, String nivel, int anio) {
		this.nombreCarrera = nombreCarrera;
		this.setNivel(nivel);
		this.setAnio(anio);
	}
	
	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
}
