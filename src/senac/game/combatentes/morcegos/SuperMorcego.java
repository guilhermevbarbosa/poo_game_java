package senac.game.combatentes.morcegos;

import senac.game.combatentes.Habilidades;
import senac.game.combatentes.Morcego;

public class SuperMorcego extends Morcego implements Habilidades {
	public SuperMorcego() {
		super("Super Morcego", 50, 120);
	}
	
	@Override
	protected boolean desviaAtaque() {
		return desviar(8);
	}
}
