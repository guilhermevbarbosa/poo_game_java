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
import senac.game.sorteios.SorteiosBatalha;

public class InputGameSelect {

//	Instancia da factory de combatente, que serve para pegar os combatentes selecionados pelo usu�rio
	CombatenteFactory combatenteFactory = new CombatenteFactory();

//	Instancia da factory de armas e armaduras, que serve para pegar o random dos dois
	ArmasFactory armasFactory = new ArmasFactory();
	ArmaduraFactory armaduraFactory = new ArmaduraFactory();

//	Classe de scanner para captar a digita��o do usu�rio
	Scanner scanner = new Scanner(System.in);

//	Cria��o do Map que vai receber as sele��es de combatentes dos usu�rios 
	public Map<Integer, Combatente> deckFormado = new HashMap<Integer, Combatente>();

//	M�todo de sele��o de combatentes para o Deck do usu�rio
	public Map<Integer, Combatente> inputSelecionarDeck(int p) {
		int countJ = 0;
		deckFormado = new HashMap<Integer, Combatente>();

		while (countJ < 1) {
			showOptionsOnInit(p);

//			Capta na pr�xima linha o Inteiro digitado pelo usu�rio, esse que determina o combatente selecionado
			int valor = scanner.nextInt();
//			Chama a factory passando o valor digitado
			Combatente combatente = combatenteFactory.selecionarCombatente(valor);

//			Com a sele��o de combatente na factory, pega o Combatente do retorno do Map e d� um put no deck, usando como �ndice o count do while
			deckFormado.put(countJ, combatente);

			if (deckFormado.get(countJ).getPodeReceberArmasEArmaduras()) {
//			Equipa arma e armadura no combatente
				setArmaEArmadura(countJ);
			}

			countJ++;
		}

//		Ap�s a inser��o de dados no deck, retorna o deckFormado por completo
		return deckFormado;
	}

//	Equipa arma e armadura nos combatentes do come�o de jogo
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

//	Mostra for�a e armadura original e os novos equipamentos
	private void showStatusSelectedCombatente(int countJ) {
		System.out.println("\n" + deckFormado.get(countJ).getNome() + " recebeu a arma "
				+ deckFormado.get(countJ).getArma().getNome() + " de ataque "
				+ deckFormado.get(countJ).getArma().getValor() + " de tipo " + deckFormado.get(countJ).getArmaTipo()
				+ "\n");

		System.out.println(deckFormado.get(countJ).getNome() + " recebeu a armadura "
				+ deckFormado.get(countJ).getArmadura().getNome() + " de defesa "
				+ deckFormado.get(countJ).getArmadura().getValor() + " de tipo "
				+ deckFormado.get(countJ).getArmaduraTipo() + "\n \n");

		System.out.println("Ataque original - " + deckFormado.get(countJ).getForcaOriginal() + " | "
				+ "Ataque com a arma - " + deckFormado.get(countJ).getForca() + "\n");
		System.out.println("Defesa original - " + deckFormado.get(countJ).getDefesaOriginal() + " | "
				+ "Defesa com a armadura - " + deckFormado.get(countJ).getDefesa() + "\n \n");
	}

//	Input de escolha dos combatentes para o deck do usu�rio
	private void showOptionsOnInit(int actualPlayer) {
		System.out.print("Jogador " + actualPlayer + " selecione 5 combatentes para montar o seu deck");
		System.out.print("\n \n");
		System.out.print("Ap�s a escolha, o combatente selecionado receber� 1 arma, 1 armadura e 1 joia. \n");
		System.out.print("*Alguns combatentes n�o podem equipar itens, apenas joias \n\n");

		System.out.println("" + "(1) Arqueiro || " + "(2) Morcego de Gelo || " + "(3) Morcego Selvagem\n \n"
				+ "(4) Blood Dragon || " + "(5) Elder Dragon || " + "(6) Orc da Montanha\n \n"
				+ "(7) Orc do Deserto || " + "(8) Bardo || " + "(9) Ninja\n \n" + "(10) Guerreiro || "
				+ "(11) Super Morcego ||" + "(12) Super Orc\n \n" + "(13) Campones || " + "(14) Ladrao || "
				+ "(15) Wendigo \n \n" + "(16) Lobisomem || " + "(17) Ghoul || " + "(18) Espectro \n \n"
				+ "(19) Centauro || " + "(20) Minotauro");
	}

//	M�todo que exibe os combatentes vivos dispon�veis para a sele��o no combate do usu�rio 
//	e pergunta qual ele quer usar na batalha seguinte
	public int inputSelecionarCombatente(int jogador, Map<Integer, Combatente> deck) {

		System.out.print("Jogador " + jogador + " selecione o combatente para batalhar");
		System.out.print("\n");

		for (Map.Entry<Integer, Combatente> item : deck.entrySet()) {
			if (item.getValue().estaVivo()) {
				System.out.println(item.getKey() + " - " + item.getValue().getNome() + " - Sa�de: "
						+ item.getValue().getVidaAtual() + " - For�a: " + item.getValue().getForca() + " - Defesa: "
						+ item.getValue().getDefesa() + " - Tipo: " + item.getValue().getTipo());
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