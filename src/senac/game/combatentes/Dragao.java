package senac.game.combatentes;

public abstract class Dragao extends Combatente implements Habilidades {

	public Dragao(String nome, int vida, String tipo) {
		super(nome, 18, vida, 25, tipo);
	}

	@Override
	protected boolean desviaAtaque() {
		return desviar(5);
	}

}
