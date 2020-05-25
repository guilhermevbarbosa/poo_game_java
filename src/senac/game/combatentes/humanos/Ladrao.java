package senac.game.combatentes.humanos;

import senac.game.combatentes.Habilidades;
import senac.game.combatentes.Humano;
import senac.game.tipos.Tipo;

public class Ladrao extends Humano implements Habilidades {
	public Ladrao() {
		super("Ladrao", 12, 90, Tipo.NORMAL);
	}
	
	@Override
	protected boolean desviaAtaque() {
		return desviar(1);
	}

}
