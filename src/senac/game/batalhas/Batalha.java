package senac.game.batalhas;

import java.util.Map;
import senac.game.combatentes.Combatente;
import senac.game.input.InputGameSelect;
import senac.game.sorteios.SorteiosBatalha;

public class Batalha {
	InputGameSelect inputGameSelect = new InputGameSelect();
	SorteiosBatalha sorteiosBatalha = new SorteiosBatalha();

	private Map<Integer, Combatente> deckJ1;
	private Map<Integer, Combatente> deckJ2;

	private int combatenteSelecionado1;
	private int combatenteSelecionado2;

	public Batalha(Map<Integer, Combatente> deckJ1, Map<Integer, Combatente> deckJ2) {
		this.deckJ1 = deckJ1;
		this.deckJ2 = deckJ2;
	}

	public void Batalhar() throws InterruptedException {
		combatenteSelecionado1 = inputGameSelect.inputSelecionarCombatente(1, deckJ1);
		combatenteSelecionado2 = inputGameSelect.inputSelecionarCombatente(2, deckJ2);

		Combatente selecionadoJ1 = deckJ1.get(combatenteSelecionado1);
		Combatente selecionadoJ2 = deckJ2.get(combatenteSelecionado2);

		while (selecionadoJ1.estaVivo() && selecionadoJ2.estaVivo()) {

			int sorteioJogador = sorteiosBatalha.sorteiaJogadores();

			if (sorteioJogador == 1) {
				int valorAtaque = sorteiosBatalha.sorteiaAtaque(selecionadoJ1.getForca());

				System.out.println(selecionadoJ2.getNome() + " recebeu " + valorAtaque + " de dano");
				selecionadoJ2.receberAtaque(valorAtaque);

				System.out.println("A vida de " + selecionadoJ1.getNome() + " - " + selecionadoJ1.getVidaAtual());
				System.out.println("A vida de " + selecionadoJ2.getNome() + " - " + selecionadoJ2.getVidaAtual());

				Thread.sleep(1000);
				System.out.println("\n");
			} else {
				int valorAtaque = sorteiosBatalha.sorteiaAtaque(selecionadoJ2.getForca());
				
				System.out.println(selecionadoJ1.getNome() + " recebeu " + valorAtaque + " de dano");
				selecionadoJ1.receberAtaque(valorAtaque);

				System.out.println("A vida de " + selecionadoJ1.getNome() + " - " + selecionadoJ1.getVidaAtual());
				System.out.println("A vida de " + selecionadoJ2.getNome() + " - " + selecionadoJ2.getVidaAtual());

				Thread.sleep(1000);
				System.out.println("\n");
			}

		}

	}

}