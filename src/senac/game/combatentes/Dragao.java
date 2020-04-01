package senac.game.combatentes;

public abstract class Dragao extends Combatente {

	public Dragao(String nome, int vida) {
		super(nome, 18, vida);
	}

	private boolean desviaAtaque() {
		return rand.nextInt(10) == 1;
	}

	@Override
	public void receberAtaque(double dano) {

		if (desviaAtaque()) {
			System.out.println(this.nome + " desviou do ataque.");
		} else {
			super.receberAtaque(dano);
		}

	}

}
