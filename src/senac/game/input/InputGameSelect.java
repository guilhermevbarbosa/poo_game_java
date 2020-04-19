package senac.game.input;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import senac.game.combatentes.Combatente;
import senac.game.factories.CombatenteFactory;

public class InputGameSelect {

//	Instancia da factory de combatente, que serve para pegar os combatentes selecionados pelo usu�rio
	CombatenteFactory combatenteFactory = new CombatenteFactory();
//	Classe de scanner para captar a digita��o do usu�rio
	Scanner scanner = new Scanner(System.in);
//	Cria��o do Map que vai receber as sele��es de combatentes dos usu�rios 
	public Map<Integer, Combatente> deckFormado = new HashMap<Integer, Combatente>();

//	M�todo de sele��o de combatentes para o Deck do usu�rio
	public Map<Integer, Combatente> inputSelecionarDeck(int p) {
		int countJ = 0;
		deckFormado = new HashMap<Integer, Combatente>();

		while (countJ < 3) {
			System.out.print("Jogador " + p + " selecione 4 combatentes para montar o seu deck");
			System.out.print("\n");

			System.out.println("(1) Arqueiro\n" + "(2) Morcego\n" + "(3) Blood Dragon\n" + "(4) Elder Dragon\n"
					+ "(5) Orc da Montanha\n" + "(6) Orc do Deserto");

//			Capta na pr�xima linha o Inteiro digitado pelo usu�rio, esse que determina o combatente selecionado
			int valor = scanner.nextInt();
//			Chama a factory passando o valor digitado
			Combatente combatente = combatenteFactory.selecionarCombatente(valor);

//			Com a sele��o de combatente na factory, pega o Combatente do retorno do Map e d� um put no deck, usando como �ndice o count do while
			deckFormado.put(countJ, combatente);
			countJ++;
		}

//		Ap�s a inser��o de dados no deck, retorna o deckFormado por completo
		return deckFormado;
	}

//	M�todo que exibe os combatentes vivos dispoiniveis para a sele��o do usu�rio e pergunta qual ele quer usar na batalha seguinte
	public int inputSelecionarCombatente(int jogador, Map<Integer, Combatente> deck) {

		System.out.print("Jogador " + jogador + " selecione o combatente para batalhar");
		System.out.print("\n");

		for (Map.Entry<Integer, Combatente> item : deck.entrySet()) {
			if (item.getValue().estaVivo()) {
				System.out.println(item.getKey() + " - " + item.getValue().getNome() + " - Sa�de: "
						+ item.getValue().getVidaAtual() + " - For�a: " + item.getValue().getForca());
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