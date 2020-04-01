package senac.game.combatentes;

public abstract class Dragao extends Combatente implements SerVoador {

	public Dragao(String nome, int vida) {
		super(nome, 18, vida);
	}

	@Override
	protected boolean desviaAtaque() {
		return desviaVoador(5);
	}

}
