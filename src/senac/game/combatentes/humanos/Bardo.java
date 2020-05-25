package senac.game.combatentes.humanos;

import senac.game.combatentes.Habilidades;
import senac.game.combatentes.Humano;
import senac.game.tipos.Tipo;

public class Bardo extends Humano implements Habilidades{
	public Bardo() {
		super("Bardo", 8, 80, Tipo.NORMAL);
	}

	@Override
	protected boolean desviaAtaque() {
		return desviar(7);
	}

}
