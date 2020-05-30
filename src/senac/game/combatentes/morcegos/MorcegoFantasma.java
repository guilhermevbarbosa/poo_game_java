package senac.game.combatentes.morcegos;

import senac.game.combatentes.Habilidades;
import senac.game.combatentes.Morcego;
import senac.game.tipos.Tipo;

public class MorcegoFantasma extends Morcego implements Habilidades {
	public MorcegoFantasma() {
		super("Morcego Fantasma", 12, 70, Tipo.FANTASMA);
	}

	@Override
	protected boolean desviaAtaque() {
		return desviar(4);
	}
}
