package senac.game.joias;

import senac.game.tipos.Tipo;

public class Joia {

	String nome;
	Tipo tipo;
//	0 - Ataque / 1 - Defesa / 3 - Tipo defesa / 4 - Tipo ataque
	int vantagem;
	int valor;

	public Joia(String nome, Tipo tipo, int vantagem, int valor) {
		this.nome = nome;
		this.tipo = tipo;
		this.vantagem = vantagem;
		this.valor = valor;
	}

	public String getNome() {
		return this.nome;
	}
	
	public Tipo getTipo() {
		return this.tipo;
	}
	
	public int getVantagem() {
		return this.vantagem;
	}
	
	public int getValor() {
		return this.valor;
	}
}
