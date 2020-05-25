package senac.game.combatentes;

import senac.game.tipos.Tipo;

public abstract class Morcego extends Combatente implements Habilidades {

	public Morcego(String nome, int ataque, int vida, Tipo tipo) {
		super(nome, ataque, vida, 8, tipo);
	}

	@Override
	protected boolean desviaAtaque() {
		return desviar(3);
	}

}
