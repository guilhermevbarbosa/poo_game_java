package java_game;

import java.util.Random;

public class Batalha {
	Random rand = new Random();
	Combatente[] jogadores = new Combatente[2];

	public Batalha(Combatente jogador1, Combatente jogador2) {
		jogadores[0] = jogador1;
		jogadores[1] = jogador2;
	}

	public int sorteiaAtaque(int valor) {
		int ataque = rand.nextInt(valor);

		return ataque;
	}

	public Combatente sorteiaJogadores() {
		int jogadorSorteado = rand.nextInt(2);

		return jogadores[jogadorSorteado];
	}

	public String Batalhar() {
		while (jogadores[0].estaVivo() && jogadores[1].estaVivo()) {
			Combatente selecionado = sorteiaJogadores();
			int valorAtaque = sorteiaAtaque(10);

			selecionado.receberAtaque(valorAtaque);

			System.out.println(selecionado.nome + " recebeu " + valorAtaque + " de dano e agora tem " + selecionado.vida + " de vida.");
		}

		if (!jogadores[0].estaVivo()) {
			return "Jogador " + jogadores[1].nome + " venceu a batalha.";
		} else {
			return "Jogador " + jogadores[0].nome + " venceu a batalha.";
		}
	}
}