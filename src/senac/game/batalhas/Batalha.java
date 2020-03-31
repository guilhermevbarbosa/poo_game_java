package senac.game.batalhas;

import java_game.Combatente;
import java.util.Random;

public class Batalha {
	private Random rand = new Random();
	private Combatente[] jogadores = new Combatente[2];

	public Batalha(Combatente jogador1, Combatente jogador2) {
		jogadores[0] = jogador1;
		jogadores[1] = jogador2;
	}

	private int sorteiaAtaque(int valor) {
		int ataque = rand.nextInt(valor);

		return ataque;
	}

	private Combatente sorteiaJogadores() {
		int jogadorSorteado = rand.nextInt(2);

		return jogadores[jogadorSorteado];
	}

	public String Batalhar() throws InterruptedException {
		while (jogadores[0].estaVivo() && jogadores[1].estaVivo()) {
			Combatente selecionado = sorteiaJogadores();
			int valorAtaque = sorteiaAtaque(10);

			System.out.println(selecionado.getNome() + " recebeu " + valorAtaque + " de dano");
			selecionado.receberAtaque(valorAtaque);

			System.out.println("A vida de " + jogadores[0].getNome() + " é " + jogadores[0].getVidaAtual());
			System.out.println("A vida de " + jogadores[1].getNome() + " é " + jogadores[1].getVidaAtual());
			
			Thread.sleep(1000);
			System.out.println("\n");
		}

		if (!jogadores[0].estaVivo()) {
			return "Jogador " + jogadores[1].getNome() + " venceu a batalha.";
		} else {
			return "Jogador " + jogadores[0].getNome() + " venceu a batalha.";
		}
	}
}