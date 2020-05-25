package senac.game.combatentes;

import senac.game.armaduras.Armadura;
import senac.game.armas.Arma;
import senac.game.tipos.Tipo;

public abstract class Combatente {

	protected String nome;
	protected int forca;
	protected int vida;
	protected int defesa;
	protected Tipo tipo;

	protected int forcaOriginal;
	protected int defesaOriginal;
	protected boolean podeReceberArmasEArmadura;

	Arma arma;
	Armadura armadura;

	public Combatente(String nome, int forca, int vida, int defesa, Tipo tipo, boolean podeReceberArmasEArmadura) {
		this.nome = nome;
		this.forca = forca;
		this.vida = vida;
		this.defesa = defesa;
		this.tipo = tipo;

		this.forcaOriginal = forca;
		this.defesaOriginal = defesa;
		this.podeReceberArmasEArmadura = podeReceberArmasEArmadura;
	}

	public int getForcaOriginal() {
		return this.forcaOriginal;
	}

	public int getDefesaOriginal() {
		return this.defesaOriginal;
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

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}

	public Arma getArma() {
		return this.arma;
	}

	public Tipo getArmaTipo() {
		return this.arma.getTipo();
	}

	public Tipo getArmaduraTipo() {
		return this.armadura.getTipo();
	}

	public Armadura getArmadura() {
		return this.armadura;
	}

//	Seta o valor do ataque com o novo valor da arma recebida
	public void setForcaUpgrade() {
		this.forca = this.forca + this.arma.getValor();
	}

//	Seta o valor da armadura com o novo valor da armadura
	public void setDefesaUpgrade() {
		this.defesa = this.defesa + this.armadura.getValor();
	}

	public boolean getPodeReceberArmasEArmaduras() {
		return podeReceberArmasEArmadura;
	}
}
