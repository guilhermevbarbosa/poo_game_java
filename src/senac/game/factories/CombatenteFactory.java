package senac.game.factories;

import senac.game.combatentes.*;
import senac.game.combatentes.dragoes.*;
import senac.game.combatentes.humanos.*;
import senac.game.combatentes.monstros.Centauro;
import senac.game.combatentes.monstros.Espectro;
import senac.game.combatentes.monstros.Ghoul;
import senac.game.combatentes.monstros.GolemDeGelo;
import senac.game.combatentes.monstros.Lobisomem;
import senac.game.combatentes.monstros.Minotauro;
import senac.game.combatentes.monstros.Wendigo;
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
		deckMap.put(13, new Campones());
		deckMap.put(14, new Ladrao());
		deckMap.put(15, new Wendigo());
		deckMap.put(16, new Lobisomem());
		deckMap.put(17, new Ghoul());
		deckMap.put(18, new Espectro());
		deckMap.put(19, new Centauro());
		deckMap.put(20, new Minotauro());
		deckMap.put(21, new MorcegoDeFogo());
		deckMap.put(22, new MorcegoFantasma());
		deckMap.put(23, new OrcCongelado());
		deckMap.put(24, new OrcFantasma());
		deckMap.put(25, new OrcFlamejante());
		deckMap.put(26, new OrcEnvenenado());
		deckMap.put(27, new DragaoComum());
		deckMap.put(28, new DragaoVenenoso());
		deckMap.put(29, new DragaoFantasma());
		deckMap.put(30, new GolemDeGelo());
	}

	public Combatente selecionarCombatente(int valor) {
		this.criarCombatentes();
		return deckMap.get(valor);
	}
}
