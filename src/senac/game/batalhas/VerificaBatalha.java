package senac.game.batalhas;

import senac.game.combatentes.Combatente;
import senac.game.sorteios.SorteiosBatalha;

public class VerificaBatalha {

	SorteiosBatalha sorteiosBatalha = new SorteiosBatalha();

	public Combatente batalhar(int sorteado, Combatente combatente1, Combatente combatente2) throws InterruptedException {
		if (sorteado == 1) {
			int valorAtaque = sorteiosBatalha.sorteiaAtaque(combatente1.getForca());

			System.out.println(combatente2.getNome() + " recebeu " + valorAtaque + " de dano");
			combatente2.receberAtaque(valorAtaque);

			System.out.println("A vida de " + combatente1.getNome() + " - " + combatente1.getVidaAtual());
			System.out.println("A vida de " + combatente2.getNome() + " - " + combatente2.getVidaAtual());

			Thread.sleep(1000);
			System.out.println("\n");
		} else {
			int valorAtaque = sorteiosBatalha.sorteiaAtaque(combatente2.getForca());

			System.out.println(combatente1.getNome() + " recebeu " + valorAtaque + " de dano");
			combatente1.receberAtaque(valorAtaque);

			System.out.println("A vida de " + combatente1.getNome() + " - " + combatente1.getVidaAtual());
			System.out.println("A vida de " + combatente2.getNome() + " - " + combatente2.getVidaAtual());

			Thread.sleep(1000);
			System.out.println("\n");
		}
		
		return getVencedor(combatente1, combatente2);
	}

	private Combatente getVencedor(Combatente combatente1, Combatente combatente2) {
		if (combatente1.estaVivo()) {
			return combatente1;
		} else {
			return combatente2;
		}
	}
}
