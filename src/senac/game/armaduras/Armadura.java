package senac.game.armaduras;

import senac.game.tipos.Tipo;

public abstract class Armadura {
	
	protected String nome;
	protected int valor;
	protected Tipo tipo;
	
	public Armadura(String nome, int valor, Tipo tipo) {
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public String getNome() {
		return this.nome;
	}

	public int getValor() {
		return this.valor;
	}

	public Tipo getTipo() {
		return this.tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}
