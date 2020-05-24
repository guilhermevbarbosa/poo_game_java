package senac.game.combatentes;

public abstract class Humano extends Combatente {
	public Humano(String nome, int forca, int vida, String tipo) {
		super(nome, forca, vida, 15, tipo);
	}
}
