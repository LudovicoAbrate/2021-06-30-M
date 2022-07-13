package it.polito.tdp.genes.model;

public class Adiacenza {

	
	String cromo1;
	String cromo2;
	double peso;
	public Adiacenza(String cromo1, String cromo2, double peso) {
		super();
		this.cromo1 = cromo1;
		this.cromo2 = cromo2;
		this.peso = peso;
	}
	public String getCromo1() {
		return cromo1;
	}
	public void setCromo1(String cromo1) {
		this.cromo1 = cromo1;
	}
	public String getCromo2() {
		return cromo2;
	}
	public void setCromo2(String cromo2) {
		this.cromo2 = cromo2;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}
