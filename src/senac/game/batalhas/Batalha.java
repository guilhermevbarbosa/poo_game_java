package senac.game.batalhas;

import java.util.List;
import java.util.Random;
import senac.game.combatentes.Combatente;

public class Batalha {
	private Random rand = new Random();
	private List<Combatente> deckJ1;
	private List<Combatente> deckJ2;

	public Batalha(List<Combatente> deckJ1, List<Combatente> deckJ2) {
		this.deckJ1 = deckJ1;
		this.deckJ2 = deckJ2;
	}

	private int sorteiaAtaque(int valor) {
		int ataque = rand.nextInt(valor);

		return ataque;
	}

	private int sorteiaJogadores() {
		int jogadorSorteado = rand.nextInt(2);

		return jogadorSorteado;
	}

	public void Batalhar() throws InterruptedException {
		int selecionado = sorteiaJogadores();

		if (selecionado == 1) {
//			JOGADOR 1
			System.out.print("Jogador 1 selecione o combatente para batalhar");
			System.out.print("\n");

			for (Combatente item : deckJ1) {
				System.out.println(item.getNome() + " - " + item.getVidaAtual());
			}
//			JOGADOR 1

//			JOGADOR 2
			System.out.print("Jogador 2 selecione o combatente para batalhar");
			System.out.print("\n");

			for (Combatente item : deckJ2) {
				System.out.println(item.getNome() + " - " + item.getVidaAtual());
			}
//			JOGADOR 2
		} else {
//			JOGADOR 2
			System.out.print("Jogador 2 selecione o combatente para batalhar");
			System.out.print("\n");

			for (Combatente item : deckJ2) {
				System.out.println(item.getNome() + " - " + item.getVidaAtual());
			}
//			JOGADOR 2
			
//			JOGADOR 1
			System.out.print("Jogador 1 selecione o combatente para batalhar");
			System.out.print("\n");

			for (Combatente item : deckJ1) {
				System.out.println(item.getNome() + " - " + item.getVidaAtual());
			}
//			JOGADOR 1		
		}

//		while (jogador[0].estaVivo() && jogador[1].estaVivo()) {
//			Combatente selecionado = sorteiaJogadores();
//			int valorAtaque = sorteiaAtaque(selecionado.getForca());
//
//			System.out.println(selecionado.getNome() + " recebeu " + valorAtaque + " de dano");
//			selecionado.receberAtaque(valorAtaque);
//
//			System.out.println("A vida de " + jogador[0].getNome() + " é " + jogador[0].getVidaAtual());
//			System.out.println("A vida de " + jogador[1].getNome() + " é " + jogador[1].getVidaAtual());
//
//			Thread.sleep(1000);
//			System.out.println("\n");
//		}
//
//		return getVencedor();
	}

//	private Combatente getVencedor() {
//		if (jogador[0].estaVivo()) {
//			return jogador[0];
//		} else {
//			return jogador[1];
//		}
//	}

}