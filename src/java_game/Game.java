package java_game;

import java.util.Map;

import senac.game.batalhas.Batalha;
import senac.game.combatentes.*;
import senac.game.input.InputGameSelect;

public class Game {

	public static void main(String[] args) throws InterruptedException {
		
//		Instância da classe de input
		InputGameSelect inputGameSelect = new InputGameSelect();

//		Cria O Map dos dois decks e passa como parametro o numero do jogador, recebe na variavel o deck formado pelo usuário
		Map<Integer, Combatente> deckJ1 = inputGameSelect.inputSelecionarDeck(1);
		Map<Integer, Combatente> deckJ2 = inputGameSelect.inputSelecionarDeck(2);

//		Manda os dois decks formados pelo usuário para a classe de batalha
		Batalha batalha = new Batalha(deckJ1, deckJ2);
		batalha.Batalhar();
//		Combatente vencedor = batalha.Batalhar();
//		System.out.println("O vencedor é " + vencedor.getNome());
	}

}
