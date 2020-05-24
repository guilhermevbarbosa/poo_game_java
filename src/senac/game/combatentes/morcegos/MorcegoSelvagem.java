package senac.game.combatentes.morcegos;

import senac.game.combatentes.Habilidades;
import senac.game.combatentes.Morcego;

public class MorcegoSelvagem extends Morcego implements Habilidades {
	public MorcegoSelvagem() {
		super("Mocego Selvagem", 10, 80);
	}

	@Override
	protected boolean desviaAtaque() {
		return desviar(3);
	}

}
