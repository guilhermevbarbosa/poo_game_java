package java_game;

import senac.game.batalhas.Batalha;

public class Game {

	public static void main(String[] args) throws InterruptedException {
		Combatente player1 = new OrcDoDeserto("OrcPlayer");
		Combatente player2 = new Dragao("DragaoPlayer");

		Batalha batalha = new Batalha(player1, player2);
		Combatente vencedor = batalha.Batalhar();
		System.out.println("O vencedor é " + vencedor.getNome());
	}

}
