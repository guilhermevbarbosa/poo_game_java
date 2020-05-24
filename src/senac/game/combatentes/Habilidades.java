package senac.game.combatentes;

import java.util.Random;

public interface Habilidades {

//	Habilidade de desviar do ataque apenas para personagens que voam ou tem muita agilidade
	default boolean desviar(int val) {
		Random rand = new Random();
		return rand.nextInt(val) == 1;
	}

}
