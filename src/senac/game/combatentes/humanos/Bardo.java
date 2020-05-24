package senac.game.combatentes.humanos;

import senac.game.combatentes.Habilidades;
import senac.game.combatentes.Humano;

public class Bardo extends Humano implements Habilidades{
	public Bardo() {
		super("Bardo", 8, 80, "Normal");
	}

	@Override
	protected boolean desviaAtaque() {
		return desviar(7);
	}

}
