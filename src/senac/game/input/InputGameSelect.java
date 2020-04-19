package senac.game.input;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import senac.game.combatentes.Combatente;
import senac.game.factories.CombatenteFactory;

public class InputGameSelect {

	CombatenteFactory combatenteFactory = new CombatenteFactory();
	Scanner scanner = new Scanner(System.in);
	public Map<Integer, Combatente> deckFormado = new HashMap<Integer, Combatente>();

	public Map<Integer, Combatente> inputSelecionarDeck(int p) {
		int countJ = 0;
		deckFormado = new HashMap<Integer, Combatente>();

		while (countJ < 4) {
			System.out.print("Jogador " + p + " selecione 4 combatentes para montar o seu deck");
			System.out.print("\n");

			System.out.println("(1) Arqueiro\n" + "(2) Morcego\n" + "(3) Blood Dragon\n" + "(4) Elder Dragon\n"
					+ "(5) Orc da Montanha\n" + "(6) Orc do Deserto");

			int valor = scanner.nextInt();
			Combatente combatente = combatenteFactory.selecionarCombatente(valor);

			deckFormado.put(countJ, combatente);

			countJ++;
		}

		return deckFormado;
	}

	public int inputSelecionarCombatente(int jogador, Map<Integer, Combatente> deck) {

			System.out.print("Jogador " + jogador + " selecione o combatente para batalhar");
			System.out.print("\n");

			for (Map.Entry<Integer, Combatente> item : deck.entrySet()) {
				if (item.getValue().estaVivo()) {
					System.out.println(item.getKey() + " - " + item.getValue().getNome() + " - Saúde: "
							+ item.getValue().getVidaAtual() + " - Força: " + item.getValue().getForca());
				}
			}

			int combatenteSelecionado = scanner.nextInt();
			return combatenteSelecionado;
	}
}