package senac.game.batalhas;

import java.util.List;
import java.util.Map;
import java.util.Random;
import senac.game.combatentes.Combatente;
import senac.game.input.InputGameSelect;

public class Batalha {
	private Random rand = new Random();
	private Map<Integer, Combatente> deckJ1;
	private Map<Integer, Combatente> deckJ2;
	InputGameSelect inputGameSelect = new InputGameSelect();

	public Batalha(Map<Integer, Combatente> deckJ1, Map<Integer, Combatente> deckJ2) {
		this.deckJ1 = deckJ1;
		this.deckJ2 = deckJ2;
	}

	private int sorteiaAtaque(int valor) {
		int ataque = rand.nextInt(valor);

		return ataque;
	}

	private int sorteiaJogadores() {
		int jogadorSorteado = rand.nextInt(2);

		return jogadorSorteado;
	}

	public void Batalhar() throws InterruptedException {
		int selecionado = sorteiaJogadores();
		inputGameSelect.inputSelecionarCombatente(selecionado, deckJ1, deckJ2);

		
	}

}