package java_game;

import java.util.List;

import senac.game.batalhas.Batalha;
import senac.game.combatentes.*;
import senac.game.input.InputGameSelect;

public class Game {

	public static void main(String[] args) throws InterruptedException {
		
		InputGameSelect inputGameSelect = new InputGameSelect();

		List<Combatente> deckJ1 = inputGameSelect.inputJogador(1);
		List<Combatente> deckJ2 = inputGameSelect.inputJogador(2);
//
//		Batalha batalha = new Batalha(player1, player2);
//		Combatente vencedor = batalha.Batalhar();
//		System.out.println("O vencedor é " + vencedor.getNome());
	}

}
