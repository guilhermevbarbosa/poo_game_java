package java_game;

public abstract class Combatente {

	private int vida = 100;
	private String nome;

	public Combatente(String nome) {
		this.nome = nome;
	}

	public boolean estaVivo() {
		if (vida > 0) {
			return true;
		}

		return false;
	}

	public int receberAtaque(double dano) {
		vida -= dano;

		return vida;
	}

	public String getNome() {
		return this.nome;
	}

	public int getVidaAtual() {
		return this.vida;
	}
}
