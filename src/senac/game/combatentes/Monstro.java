package senac.game.combatentes;

import senac.game.tipos.Tipo;

public class Monstro extends Combatente {
	public Monstro(String nome, int forca, int vida, Tipo tipo) {
		super(nome, forca, vida, 18, tipo, true);
	}
}
