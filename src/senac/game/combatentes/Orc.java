package senac.game.combatentes;

import senac.game.tipos.Tipo;

public abstract class Orc extends Combatente {
	public Orc(String nome, int forca, Tipo tipo) {
		super(nome, forca, 80, 20, tipo);
	}
}
