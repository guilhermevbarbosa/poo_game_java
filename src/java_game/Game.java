package java_game;

import senac.game.batalhas.Batalha;
import senac.game.combatentes.Combatente;
import senac.game.combatentes.dragoes.BloodDragon;
import senac.game.combatentes.orcs.OrcDaMontanha;

public class Game {

	public static void main(String[] args) throws InterruptedException {
		Combatente player1 = new BloodDragon("DragaoPlayer");
		Combatente player2 = new OrcDaMontanha("OrcMontanhaPlayer");

		Batalha batalha = new Batalha(player1, player2);
		Combatente vencedor = batalha.Batalhar();
		System.out.println("O vencedor é " + vencedor.getNome());
	}

}
