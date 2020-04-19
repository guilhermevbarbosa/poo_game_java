package senac.game.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import senac.game.combatentes.Combatente;
import senac.game.factories.CombatenteFactory;

public class InputGameSelect {

	CombatenteFactory combatenteFactory = new CombatenteFactory();
	List<Combatente> deckFormado = new ArrayList<Combatente>();
	Scanner scanner = new Scanner(System.in);

	public List<Combatente> inputJogador(int p) {
		int countJ = 0;

		while (countJ < 4) {
			System.out.print("Jogador " + p + " selecione 4 combatentes para montar o seu deck");
			System.out.print("\n");

			System.out.println("(1) Arqueiro\n" + "(2) Morcego\n" + "(3) Blood Dragon\n" + "(4) Elder Dragon\n"
					+ "(5) Orc da Montanha\n" + "(6) Orc do Deserto");

			int valor = scanner.nextInt();
			Combatente combatente = combatenteFactory.selecionarCombatente(valor);
			deckFormado.add(combatente);
			countJ++;
		}

		return deckFormado;
	}
}