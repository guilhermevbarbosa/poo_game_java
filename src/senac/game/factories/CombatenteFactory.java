package senac.game.factories;

import senac.game.combatentes.*;
import senac.game.combatentes.dragoes.*;
import senac.game.combatentes.orcs.*;

import java.util.HashMap;
import java.util.Map;

public class CombatenteFactory {
	public Map<Integer, Combatente> deckMap = new HashMap<Integer, Combatente>();

	private void criarCombatentes() {
		deckMap.put(1, new Arqueiro());
		deckMap.put(2, new Morcego());
		deckMap.put(3, new BloodDragon());
		deckMap.put(4, new ElderDragon());
		deckMap.put(5, new OrcDaMontanha());
		deckMap.put(6, new OrcDoDeserto());
	}

	public Combatente selecionarCombatente(int valor) {
		this.criarCombatentes();
		return deckMap.get(valor);
	}
}
