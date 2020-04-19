package senac.game.combatentes;

public class Morcego extends Combatente implements SerVoador {

	public Morcego() {
		super("Morcego", 10, 70);
	}

	@Override
	protected boolean desviaAtaque() {
		return desviaVoador(3);
	}

}
