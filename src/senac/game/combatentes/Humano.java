package senac.game.combatentes;

import senac.game.tipos.Tipo;

public abstract class Humano extends Combatente {
	public Humano(String nome, int forca, int vida, Tipo tipo) {
		super(nome, forca, vida, 15, tipo, true);
	}
}
