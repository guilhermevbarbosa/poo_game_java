package senac.game.combatentes;

public abstract class Morcego extends Combatente implements Habilidades {

	public Morcego(String nome, int ataque, int vida, String tipo) {
		super(nome, ataque, vida, 8, tipo);
	}

	@Override
	protected boolean desviaAtaque() {
		return desviar(3);
	}

}
