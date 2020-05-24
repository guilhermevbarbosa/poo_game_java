package senac.game.combatentes.humanos;

import senac.game.combatentes.Combatente;
import senac.game.combatentes.Habilidades;

public class Bardo extends Combatente implements Habilidades{
	public Bardo() {
		super("Bardo", 8, 80);
	}

	@Override
	protected boolean desviaAtaque() {
		return desviar(7);
	}

}
