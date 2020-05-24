package senac.game.combatentes;

import java.util.Random;

public interface Habilidades {
	
	default boolean desviar(int val) {
		Random rand = new Random();
		return rand.nextInt(val) == 1;
	}
	
}
