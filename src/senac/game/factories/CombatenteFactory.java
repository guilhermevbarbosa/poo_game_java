package senac.game.factories;

import senac.game.combatentes.*;
import senac.game.combatentes.dragoes.*;
import senac.game.combatentes.humanos.*;
import senac.game.combatentes.orcs.*;
import senac.game.combatentes.morcegos.*;

import java.util.HashMap;
import java.util.Map;

public class CombatenteFactory {
	public Map<Integer, Combatente> deckMap = new HashMap<Integer, Combatente>();

	private void criarCombatentes() {
		deckMap.put(1, new Arqueiro());
		deckMap.put(2, new MorcegoDeGelo());
		deckMap.put(3, new MorcegoSelvagem());
		deckMap.put(4, new BloodDragon());
		deckMap.put(5, new ElderDragon());
		deckMap.put(6, new OrcDaMontanha());
		deckMap.put(7, new OrcDoDeserto());
		deckMap.put(8, new Bardo());
		deckMap.put(9, new Ninja());
		deckMap.put(10, new Guerreiro());
		deckMap.put(11, new SuperMorcego());
		deckMap.put(12, new SuperOrc());
	}

	public Combatente selecionarCombatente(int valor) {
		this.criarCombatentes();
		return deckMap.get(valor);
	}
}
