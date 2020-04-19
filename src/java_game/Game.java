package java_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import factories.CombatenteFactory;
import senac.game.batalhas.Batalha;
import senac.game.combatentes.*;

public class Game {

	public static void main(String[] args) throws InterruptedException {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		List<Combatente> deckFormadoP1 = new ArrayList<Combatente>();
		List<Combatente> deckFormadoP2 = new ArrayList<Combatente>();

		CombatenteFactory combatenteFactory = new CombatenteFactory();

		int countJ1 = 0;
		int countJ2 = 0;

		while (countJ1 < 4) {
			System.out.print("Jogador 1 selecione 4 combatentes para montar o seu deck");
			System.out.print("\n");

			System.out.println("(1) Arqueiro\n"
					+ "(2) Morcego\n"
					+ "(3) Blood Dragon\n"
					+ "(4) Elder Dragon\n"
					+ "(5) Orc da Montanha\n"
					+ "(6) Orc do Deserto");

			int valor = scanner.nextInt();
			Combatente combatente = combatenteFactory.selecionarCombatente(valor);
			deckFormadoP1.add(combatente);
			countJ1++;
		}

		while (countJ2 < 4) {
			System.out.print("Jogador 2 selecione 4 combatentes para montar o seu deck");
			System.out.print("\n");

			System.out.println("(1) Arqueiro\n"
					+ "(2) Morcego\n"
					+ "(3) Blood Dragon\n"
					+ "(4) Elder Dragon\n"
					+ "(5) Orc da Montanha\n"
					+ "(6) Orc do Deserto");

			int valor = scanner.nextInt();
			Combatente combatente = combatenteFactory.selecionarCombatente(valor);
			deckFormadoP2.add(combatente);
			countJ2++;
		}

//		Combatente player1 = new BloodDragon();
//		Combatente player2 = new OrcDaMontanha();
//
//		Batalha batalha = new Batalha(player1, player2);
//		Combatente vencedor = batalha.Batalhar();
//		System.out.println("O vencedor é " + vencedor.getNome());
	}

}
