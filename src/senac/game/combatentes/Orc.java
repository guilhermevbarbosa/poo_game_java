package senac.game.combatentes;

public abstract class Orc extends Combatente {
	public Orc(String nome, int forca, String tipo) {
		super(nome, forca, 80, 20, tipo);
	}
}
