package senac.game.combatentes.humanos;

import senac.game.combatentes.Habilidades;
import senac.game.combatentes.Humano;
import senac.game.tipos.Tipo;

public class Ninja extends Humano implements Habilidades {
	public Ninja() {
		super("Ninja", 10, 100, Tipo.NORMAL);
	}
	
	@Override
	protected boolean desviaAtaque() {
		return desviar(2);
	}

}
