package senac.game.factories;

import senac.game.combatentes.*;
import senac.game.combatentes.dragoes.*;
import senac.game.combatentes.orcs.*;

public class CombatenteFactory {

	public Combatente selecionarCombatente(int valor) {
		switch (valor) {
		case 1:
			return new Arqueiro();
		case 2:
			return new Morcego();
		case 3:
			return new BloodDragon();
		case 4:
			return new ElderDragon();
		case 5:
			return new OrcDaMontanha();
		case 6:
			return new OrcDoDeserto();
		default:
			return null;
		}

	}
}
