package senac.game.armas;

import senac.game.tipos.Tipo;

public abstract class Arma {
	
	String nome; 
	int valor;
	Tipo tipo;
	
	public Arma(String nome, int valor, Tipo tipo) {
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	
}
