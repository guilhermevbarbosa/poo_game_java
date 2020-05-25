package senac.game.combatentes;

import senac.game.tipos.Tipo;

public abstract class Combatente {

	protected String nome;
	protected int forca;
	protected int vida;

	protected int defesa;

	protected Tipo tipo;

	public Combatente(String nome, int forca, int vida, int defesa, Tipo tipo) {
		this.nome = nome;
		this.forca = forca;
		this.vida = vida;
		this.defesa = defesa;
		this.tipo = tipo;
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

	public int getDefesa() {
		return this.defesa;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

//	Seta o valor do ataque com o novo valor da arma recebida
	public void setForcaUpgrade(int forcaPlus) {
		this.forca = this.forca + forcaPlus;
	}

//	Seta o valor da armadura com o novo valor da armadura
	public void setDefesaUpgrade(int defesaPlus) {
		this.defesa = this.defesa + defesaPlus;
	}
}
