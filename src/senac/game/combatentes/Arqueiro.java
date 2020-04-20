package senac.game.combatentes;

public class Arqueiro extends Combatente{
	
	int hash;
	
	public Arqueiro() {
		super("Arqueiro", 10, 100);
		this.hash = this.hashCode();
	}
	
}
