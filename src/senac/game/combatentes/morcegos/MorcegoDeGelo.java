package senac.game.combatentes.morcegos;

import senac.game.combatentes.Habilidades;
import senac.game.combatentes.Morcego;
import senac.game.tipos.Tipo;

public class MorcegoDeGelo extends Morcego implements Habilidades {
	public MorcegoDeGelo() {
		super("Morcego de Gelo", 10, 75, Tipo.GELO);
	}
	
	@Override
	protected boolean desviaAtaque() {
		return desviar(4);
	}
}
