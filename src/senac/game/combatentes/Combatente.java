package senac.game.combatentes;

public abstract class Combatente {

	protected int vida;
	protected int forca;
	protected String nome;

	public Combatente(String nome, int forca, int vida) {
		this.nome = nome;
		this.forca = forca;
		this.vida = vida;
	}

	public boolean estaVivo() {
		if (vida > 0) {
			return true;
		}

		return false;
	}

	public void receberAtaque(double dano) {

		if (desviaAtaque()) {
			System.out.println(this.nome + " desviou do ataque.");
		} else {
			if (dano > vida) {
				vida = 0;
			} else {
				vida -= dano;
			}
		}

	}

	protected boolean desviaAtaque() {
		return false;
	}

	public String getNome() {
		return this.nome;
	}

	public int getVidaAtual() {
		return this.vida;
	}

	public int getForca() {
		return this.forca;
	}
}
