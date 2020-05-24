package senac.game.combatentes.humanos;

import senac.game.combatentes.Habilidades;
import senac.game.combatentes.Humano;

public class Ladrao extends Humano implements Habilidades {
	public Ladrao() {
		super("Ladrao", 12, 90, "Normal");
	}
	
	@Override
	protected boolean desviaAtaque() {
		return desviar(1);
	}

}
