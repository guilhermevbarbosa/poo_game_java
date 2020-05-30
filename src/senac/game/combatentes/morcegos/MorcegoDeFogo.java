package senac.game.combatentes.morcegos;

import senac.game.combatentes.Habilidades;
import senac.game.combatentes.Morcego;
import senac.game.tipos.Tipo;

public class MorcegoDeFogo extends Morcego implements Habilidades {
	public MorcegoDeFogo() {
		super("Morcego de Fogo", 10, 78, Tipo.FOGO);
	}

	@Override
	protected boolean desviaAtaque() {
		return desviar(4);
	}
}
