package senac.game.batalhas;

import java.util.Map;
import senac.game.combatentes.Combatente;
import senac.game.input.InputGameSelect;
import senac.game.sorteios.SorteiosBatalha;

public class Batalha {
	InputGameSelect inputGameSelect = new InputGameSelect();
	SorteiosBatalha sorteiosBatalha = new SorteiosBatalha();
	
	private Map<Integer, Combatente> deckJ1;
	private Map<Integer, Combatente> deckJ2;

	public Batalha(Map<Integer, Combatente> deckJ1, Map<Integer, Combatente> deckJ2) {
		this.deckJ1 = deckJ1;
		this.deckJ2 = deckJ2;
	}

	public void Batalhar() throws InterruptedException {
		int selecionado = sorteiosBatalha.sorteiaJogadores();
		inputGameSelect.inputSelecionarCombatente(selecionado, deckJ1, deckJ2);
	}

}