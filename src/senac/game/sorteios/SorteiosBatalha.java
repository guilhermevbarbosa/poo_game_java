package senac.game.sorteios;

import java.util.Random;

public class SorteiosBatalha {
	private Random rand = new Random();

	public int sorteiaAtaque(int valor) {
		int ataque = rand.nextInt(valor);

		return ataque;
	}

	public int sorteiaJogadores() {
		int jogadorSorteado = rand.nextInt(2);
		
		if(jogadorSorteado == 0 ) {
			jogadorSorteado = 1;
		}else {
			jogadorSorteado = 2;
		}

		return jogadorSorteado;
	}
}
