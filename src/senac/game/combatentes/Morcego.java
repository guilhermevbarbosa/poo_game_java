package senac.game.combatentes;

public abstract class Morcego extends Combatente implements Habilidades {

	public Morcego(String nome, int ataque, int vida) {
		super(nome, ataque, vida);
	}

	@Override
	protected boolean desviaAtaque() {
		return desviar(3);
	}

}
