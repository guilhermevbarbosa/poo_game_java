package senac.game.combatentes;

import senac.game.tipos.Tipo;

public abstract class Dragao extends Combatente implements Habilidades {

	public Dragao(String nome, int vida, Tipo tipo) {
		super(nome, 18, vida, 25, tipo, false);
	}

	@Override
	protected boolean desviaAtaque() {
		return desviar(5);
	}

}
