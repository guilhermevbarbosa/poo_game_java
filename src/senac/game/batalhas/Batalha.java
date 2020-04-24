package senac.game.batalhas;

import java.util.Map;
import senac.game.combatentes.Combatente;
import senac.game.input.InputGameSelect;
import senac.game.sorteios.SorteiosBatalha;

public class Batalha {
	InputGameSelect inputGameSelect = new InputGameSelect();
	SorteiosBatalha sorteiosBatalha = new SorteiosBatalha();
	VerificaBatalha verificaBatalha = new VerificaBatalha();

	private Map<Integer, Combatente> deckJ1;
	private Map<Integer, Combatente> deckJ2;

	private int combatenteSelecionado1;
	private int combatenteSelecionado2;
	Combatente vencedor;

//	Construtor da classe Batalha, recebe da main os Maps dos dois decks já formados pelos jogadores
	public Batalha(Map<Integer, Combatente> deckJ1, Map<Integer, Combatente> deckJ2) {
		this.deckJ1 = deckJ1;
		this.deckJ2 = deckJ2;
	}

	public void Batalhar() throws InterruptedException {

		while (inputGameSelect.contaVivos(deckJ1) > 0 && inputGameSelect.contaVivos(deckJ2) > 0) {

//			Passa o Deck 1 e 2 já completo para o input de escolha de combatente
			combatenteSelecionado1 = inputGameSelect.inputSelecionarCombatente(1, deckJ1);
			combatenteSelecionado2 = inputGameSelect.inputSelecionarCombatente(2, deckJ2);

//			Pega  retorno da seleção do usuario qual combate ele quer usar e dá um get do combatente
			Combatente selecionadoJ1 = deckJ1.get(combatenteSelecionado1);
			Combatente selecionadoJ2 = deckJ2.get(combatenteSelecionado2);
			
			while (selecionadoJ1.estaVivo() && selecionadoJ2.estaVivo()) {
//				Sorteia qual jogador ataca primeiro em cada rodada
				int sorteioJogador = sorteiosBatalha.sorteiaJogadores();

//				Passa o jogador sorteado e os dois selecionados para a classe do combate que esta acontencendo
				vencedor = verificaBatalha.batalhar(sorteioJogador, selecionadoJ1, selecionadoJ2);
			}

//			Quando acaba aquela batalha exibe o vencedor
			System.out.println("O ganhador da batalha foi " + vencedor.getNome() + " com vida de "
					+ vencedor.getVidaAtual());
		}

		if (inputGameSelect.contaVivos(deckJ1) == 0) {
			System.out.println("O jogador 2 foi o ganhador da partida");
		} else {
			System.out.println("O jogador 1 foi o ganhador da partida");
		}
	}

}