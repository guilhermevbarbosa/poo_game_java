package senac.game.combatentes;
import java.util.Random;

public abstract class Combatente {
	
	protected Random rand = new Random();
	private int vida;
	private int forca;
	private String nome;

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

	public int receberAtaque(double dano) {

		if (dano > vida) {
			vida = 0;
		} else {
			vida -= dano;
		}

		return vida;
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
