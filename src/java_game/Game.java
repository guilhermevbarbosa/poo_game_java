package java_game;

import java.util.Map;

import senac.game.batalhas.Batalha;
import senac.game.combatentes.*;
import senac.game.input.InputGameSelect;

public class Game {

	public static void main(String[] args) throws InterruptedException {
		
		InputGameSelect inputGameSelect = new InputGameSelect();

		Map<Integer, Combatente> deckJ1 = inputGameSelect.inputSelecionarDeck(1);
		Map<Integer, Combatente> deckJ2 = inputGameSelect.inputSelecionarDeck(2);

		Batalha batalha = new Batalha(deckJ1, deckJ2);
		batalha.Batalhar();
//		Combatente vencedor = batalha.Batalhar();
//		System.out.println("O vencedor é " + vencedor.getNome());
	}

}
