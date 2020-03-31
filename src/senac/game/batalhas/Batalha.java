package senac.game.batalhas;

import java_game.Combatente;
import java.util.Random;

public class Batalha {
	private Random rand = new Random();
	private Combatente[] jogador = new Combatente[2];

	public Batalha(Combatente jogador1, Combatente jogador2) {
		jogador[0] = jogador1;
		jogador[1] = jogador2;
	}

	private int sorteiaAtaque(int valor) {
		int ataque = rand.nextInt(valor);

		return ataque;
	}

	private Combatente sorteiaJogadores() {
		int jogadorSorteado = rand.nextInt(2);

		return jogador[jogadorSorteado];
	}

	public Combatente Batalhar() throws InterruptedException {
		while (jogador[0].estaVivo() && jogador[1].estaVivo()) {
			Combatente selecionado = sorteiaJogadores();
			int valorAtaque = sorteiaAtaque(10);

			System.out.println(selecionado.getNome() + " recebeu " + valorAtaque + " de dano");
			selecionado.receberAtaque(valorAtaque);

			System.out.println("A vida de " + jogador[0].getNome() + " é " + jogador[0].getVidaAtual());
			System.out.println("A vida de " + jogador[1].getNome() + " é " + jogador[1].getVidaAtual());

			Thread.sleep(1000);
			System.out.println("\n");
		}

		return getVencedor();
	}

	private Combatente getVencedor() {
		if (jogador[0].estaVivo()) {
			return jogador[0];
		} else {
			return jogador[1];
		}
	}

}