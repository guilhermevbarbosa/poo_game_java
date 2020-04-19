package senac.game.input;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import senac.game.combatentes.Combatente;
import senac.game.factories.CombatenteFactory;

public class InputGameSelect {

//	Instancia da factory de combatente, que serve para pegar os combatentes selecionados pelo usuário
	CombatenteFactory combatenteFactory = new CombatenteFactory();
//	Classe de scanner para captar a digitação do usuário
	Scanner scanner = new Scanner(System.in);
//	Criação do Map que vai receber as seleções de combatentes dos usuários 
	public Map<Integer, Combatente> deckFormado = new HashMap<Integer, Combatente>();

//	Método de seleção de combatentes para o Deck do usuário
	public Map<Integer, Combatente> inputSelecionarDeck(int p) {
		int countJ = 0;
		deckFormado = new HashMap<Integer, Combatente>();

		while (countJ < 3) {
			System.out.print("Jogador " + p + " selecione 4 combatentes para montar o seu deck");
			System.out.print("\n");

			System.out.println("(1) Arqueiro\n" + "(2) Morcego\n" + "(3) Blood Dragon\n" + "(4) Elder Dragon\n"
					+ "(5) Orc da Montanha\n" + "(6) Orc do Deserto");

//			Capta na próxima linha o Inteiro digitado pelo usuário, esse que determina o combatente selecionado
			int valor = scanner.nextInt();
//			Chama a factory passando o valor digitado
			Combatente combatente = combatenteFactory.selecionarCombatente(valor);

//			Com a seleção de combatente na factory, pega o Combatente do retorno do Map e dá um put no deck, usando como índice o count do while
			deckFormado.put(countJ, combatente);
			countJ++;
		}

//		Após a inserção de dados no deck, retorna o deckFormado por completo
		return deckFormado;
	}

//	Método que exibe os combatentes vivos dispoiniveis para a seleção do usuário e pergunta qual ele quer usar na batalha seguinte
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

	public int contaVivos(Map<Integer, Combatente> deck) {
		int countVivos = 0;

		for (Map.Entry<Integer, Combatente> item : deck.entrySet()) {
			if (item.getValue().estaVivo()) {
				countVivos++;
			}
		}

		return countVivos;
	}
}