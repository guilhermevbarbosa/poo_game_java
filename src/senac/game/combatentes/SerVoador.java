package senac.game.combatentes;

import java.util.Random;

public interface SerVoador {
	
	default boolean desviaVoador(int val) {
		Random rand = new Random();
		return rand.nextInt(val) == 1;
	}
	
}
