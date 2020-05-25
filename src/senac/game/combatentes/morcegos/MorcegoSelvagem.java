package senac.game.combatentes.morcegos;

import senac.game.combatentes.Habilidades;
import senac.game.combatentes.Morcego;
import senac.game.tipos.Tipo;

public class MorcegoSelvagem extends Morcego implements Habilidades {
	public MorcegoSelvagem() {
		super("Morcego Selvagem", 10, 80, Tipo.VENENO);
	}

	@Override
	protected boolean desviaAtaque() {
		return desviar(3);
	}

}
