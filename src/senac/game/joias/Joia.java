package senac.game.joias;

import senac.game.tipos.Tipo;

public class Joia {

	String nome;
	Tipo tipo;
//	0 - Ataque / 1 - Defesa
	int vantagem;

	public Joia(String nome, Tipo tipo, int vantagem) {
		this.nome = nome;
		this.tipo = tipo;
		this.vantagem = vantagem;
	}

}
