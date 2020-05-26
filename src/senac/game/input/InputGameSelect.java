package senac.game.input;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import senac.game.armaduras.Armadura;
import senac.game.armas.Arma;
import senac.game.combatentes.Combatente;
import senac.game.factories.ArmaduraFactory;
import senac.game.factories.ArmasFactory;
import senac.game.factories.CombatenteFactory;
import senac.game.factories.JoiasFactory;
import senac.game.joias.Joia;
import senac.game.sorteios.SorteiosBatalha;

public class InputGameSelect {

//	Instancia da factory de combatente, que serve para pegar os combatentes selecionados pelo usuário
	CombatenteFactory combatenteFactory = new CombatenteFactory();

//	Instancia da factory de armas e armaduras, que serve para pegar o random dos dois
	ArmasFactory armasFactory = new ArmasFactory();
	ArmaduraFactory armaduraFactory = new ArmaduraFactory();
	JoiasFactory joiaFactory = new JoiasFactory();

//	Classe de scanner para captar a digitação do usuário
	Scanner scanner = new Scanner(System.in);

//	Criação do Map que vai receber as seleções de combatentes dos usuários 
	public Map<Integer, Combatente> deckFormado = new HashMap<Integer, Combatente>();

//	Método de seleção de combatentes para o Deck do usuário
	public Map<Integer, Combatente> inputSelecionarDeck(int p) {
		int countJ = 0;
		deckFormado = new HashMap<Integer, Combatente>();

		while (countJ < 5) {
			showOptionsOnInit(p);

//			Capta na próxima linha o Inteiro digitado pelo usuário, esse que determina o combatente selecionado
			int valor = scanner.nextInt();
//			Chama a factory passando o valor digitado
			Combatente combatente = combatenteFactory.selecionarCombatente(valor);

//			Com a seleção de combatente na factory, pega o Combatente do retorno do Map e dá um put no deck, usando como índice o count do while
			deckFormado.put(countJ, combatente);

			if (deckFormado.get(countJ).getPodeReceberArmasEArmaduras()) {
//			Equipa arma e armadura no combatente
				setArmaEArmadura(countJ);
			}

//			Sorteia e equipa a jóia
			setJoias(countJ);

			countJ++;
		}

//		Após a inserção de dados no deck, retorna o deckFormado por completo
		return deckFormado;
	}

//	Equipa arma e armadura nos combatentes do começo de jogo
	private void setArmaEArmadura(int countJ) {
		SorteiosBatalha sorteioClass = new SorteiosBatalha();

		int sortArma = sorteioClass.sorteiaArmasEArmadura();
		int sortArmadura = sorteioClass.sorteiaArmasEArmadura();

		Arma armaSorteada = armasFactory.selecionarArma(sortArma);
		Armadura armaduraSorteada = armaduraFactory.selecionarArmadura(sortArmadura);

		deckFormado.get(countJ).setArma(armaSorteada);
		deckFormado.get(countJ).setArmadura(armaduraSorteada);

		deckFormado.get(countJ).setForcaUpgrade();
		deckFormado.get(countJ).setDefesaUpgrade();
		
		showStatusSelectedCombatente(countJ);
	}

	private void setJoias(int countJ) {
		SorteiosBatalha sorteioClass = new SorteiosBatalha();

		int sortJoia = sorteioClass.sorteiaJoias();
		Joia joiaSorteada = joiaFactory.selecionarJoia(sortJoia);
		deckFormado.get(countJ).setJoia(joiaSorteada);

		if (joiaSorteada.getVantagem() == 0) {
			deckFormado.get(countJ).setForcaJoia(joiaSorteada.getValor());
		} else if (joiaSorteada.getVantagem() == 1) {
			deckFormado.get(countJ).setDefesaJoia(joiaSorteada.getValor());
		} else if (joiaSorteada.getVantagem() == 3) {
			if (deckFormado.get(countJ).getPodeReceberArmasEArmaduras()) {
				deckFormado.get(countJ).getArma().setTipo(joiaSorteada.getTipo());
			} else {
				deckFormado.get(countJ).setTipo(joiaSorteada.getTipo());
			}
		} else {
			if (deckFormado.get(countJ).getPodeReceberArmasEArmaduras()) {
				deckFormado.get(countJ).getArmadura().setTipo(joiaSorteada.getTipo());
			} else {
				deckFormado.get(countJ).setTipo(joiaSorteada.getTipo());
			}
		}
		
		showStatusJoiasCombatente(countJ);
	}

//	Mostra força e armadura original e os novos equipamentos
	private void showStatusSelectedCombatente(int countJ) {
		System.out.println("\n" + deckFormado.get(countJ).getNome() + " recebeu a arma "
				+ deckFormado.get(countJ).getArma().getNome() + " de ataque "
				+ deckFormado.get(countJ).getArma().getValor() + " de tipo " + deckFormado.get(countJ).getArmaTipo()
				+ "\n");

		System.out.println(deckFormado.get(countJ).getNome() + " recebeu a armadura "
				+ deckFormado.get(countJ).getArmadura().getNome() + " de defesa "
				+ deckFormado.get(countJ).getArmadura().getValor() + " de tipo "
				+ deckFormado.get(countJ).getArmaduraTipo() + "\n");
	}
	
	private void showStatusJoiasCombatente(int countJ) {
		String vantagem;

		if (deckFormado.get(countJ).getJoia().getVantagem() == 0) {
			vantagem = "Ataque";
		} else if (deckFormado.get(countJ).getJoia().getVantagem() == 1) {
			vantagem = "Defesa";
		} else if (deckFormado.get(countJ).getJoia().getVantagem() == 3) {
			vantagem = "Alteração do tipo Defesa";
		} else {
			vantagem = "Alteração do tipo Ataque";
		}

		System.out.println("\n" + deckFormado.get(countJ).getNome() + " recebeu "
				+ deckFormado.get(countJ).getJoia().getNome() + " e tem efeito de " + vantagem + "\n\n");

		System.out.println("Ataque original - " + deckFormado.get(countJ).getForcaOriginal() + " | " + "Ataque atual - "
				+ deckFormado.get(countJ).getForca() + "\n");
		System.out.println("Defesa original - " + deckFormado.get(countJ).getDefesaOriginal() + " | "
				+ "Defesa atual - " + deckFormado.get(countJ).getDefesa() + "\n \n");
	}


//	Input de escolha dos combatentes para o deck do usuário
	private void showOptionsOnInit(int actualPlayer) {
		System.out.print("Jogador " + actualPlayer + " selecione 5 combatentes para montar o seu deck");
		System.out.print("\n \n");
		System.out.print("Após a escolha, o combatente selecionado receberá 1 arma, 1 armadura e 1 joia. \n");
		System.out.print("*Alguns combatentes não podem equipar itens, apenas joias \n\n");

		System.out.println("" + "(1) Arqueiro || " + "(2) Morcego de Gelo || " + "(3) Morcego Selvagem\n \n"
				+ "(4) Blood Dragon || " + "(5) Elder Dragon || " + "(6) Orc da Montanha\n \n"
				+ "(7) Orc do Deserto || " + "(8) Bardo || " + "(9) Ninja\n \n" + "(10) Guerreiro || "
				+ "(11) Super Morcego ||" + "(12) Super Orc\n \n" + "(13) Campones || " + "(14) Ladrao || "
				+ "(15) Wendigo \n \n" + "(16) Lobisomem || " + "(17) Ghoul || " + "(18) Espectro \n \n"
				+ "(19) Centauro || " + "(20) Minotauro");
	}

//	Método que exibe os combatentes vivos disponíveis para a seleção no combate do usuário 
//	e pergunta qual ele quer usar na batalha seguinte
	public int inputSelecionarCombatente(int jogador, Map<Integer, Combatente> deck) {

		System.out.print("Jogador " + jogador + " selecione o combatente para batalhar");
		System.out.print("\n");

		for (Map.Entry<Integer, Combatente> item : deck.entrySet()) {
			if (item.getValue().estaVivo()) {
				System.out.println(item.getKey() + " - " + item.getValue().getNome() + " - Saúde: "
						+ item.getValue().getVidaAtual() + " - Força: " + item.getValue().getForca() + " - Defesa: "
						+ item.getValue().getDefesa());
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