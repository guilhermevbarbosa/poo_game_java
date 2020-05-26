package senac.game.joias;

import senac.game.tipos.Tipo;

public class Joia {

	String nome;
	Tipo tipo;
//	0 - Ataque / 1 - Defesa / 3 - Tipo
	int vantagem;
	int valor;

	public Joia(String nome, Tipo tipo, int vantagem, int valor) {
		this.nome = nome;
		this.tipo = tipo;
		this.vantagem = vantagem;
		this.valor = valor;
	}

}
