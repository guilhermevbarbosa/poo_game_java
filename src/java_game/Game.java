package java_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import factories.CombatenteFactory;
import senac.game.batalhas.Batalha;
import senac.game.combatentes.*;

public class Game {

	public static void main(String[] args) throws InterruptedException {

		Scanner player1Input = new Scanner(System.in);
		List<Combatente> deckFormadoP1 = new ArrayList<Combatente>();

		Scanner player2Input = new Scanner(System.in);
		List<Combatente> deckFormadoP2 = new ArrayList<Combatente>();

		CombatenteFactory combatenteFactory = new CombatenteFactory();

		int j1 = 0;

		while (j1 < 5) {
			System.out.print("Selecione 5 combatentes para montar o seu deck");
			System.out.println(
					"(1) Arqueiro, (2) Morcego, (3) Blood Dragon, (4) Elder Dragon, (5) Orc da Montanha (6) Orc do Deserto");

			int valor = player1Input.nextInt();
			Combatente combatente = combatenteFactory.selecionarCombatente(valor);
			deckFormadoP1.add(combatente);
			j1++;
		}

		for (Combatente item : deckFormadoP1) {
			System.out.println(item);
		}

//		Combatente player1 = new BloodDragon();
//		Combatente player2 = new OrcDaMontanha();
//
//		Batalha batalha = new Batalha(player1, player2);
//		Combatente vencedor = batalha.Batalhar();
//		System.out.println("O vencedor é " + vencedor.getNome());
	}

}
