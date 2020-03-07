package java_game;
import java.util.Random;

public class Game {

	public static void main(String[] args) {
		Combatente player1 = new OrcDoDeserto("OrcPlayer");
		Combatente player2 = new Dragao("DragaoPlayer");

		Random rand = new Random();
		int numRand = 101;

		while (player1.estaVivo(player1.vida) && player2.estaVivo(player2.vida)) {
			int randomAttackP1 = rand.nextInt(numRand);
			int randomAttackP2 = rand.nextInt(numRand);

			if (player1.vida > 0 && player2.vida > 0) {
				player1.receberAtaque(randomAttackP1);
				System.out.println("O jogador " + player1.nome + " recebeu " + randomAttackP1 + " de dano.");
			}

			if (player2.vida > 0 && player1.vida > 0) {
				player2.receberAtaque(randomAttackP2);
				System.out.println("O jogador " + player2.nome + " recebeu " + randomAttackP2 + " de dano.");
			}
		}

		if (!player1.estaVivo(player1.vida)) {
			System.out.println("O jogador " + player1.nome + " perdeu");
		} else {
			System.out.println("O jogador " + player2.nome + " perdeu");
		}

	}

}
