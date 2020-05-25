package senac.game.combatentes.morcegos;

import senac.game.combatentes.Habilidades;
import senac.game.combatentes.Morcego;
import senac.game.tipos.Tipo;

public class SuperMorcego extends Morcego implements Habilidades {
	public SuperMorcego() {
		super("Super Morcego", 30, 110, Tipo.NORMAL);
	}
	
	@Override
	protected boolean desviaAtaque() {
		return desviar(8);
	}
}
