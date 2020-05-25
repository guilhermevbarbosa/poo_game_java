package senac.game.batalhas;

import senac.game.combatentes.Combatente;
import senac.game.sorteios.SorteiosBatalha;

public class VerificaBatalha {

	SorteiosBatalha sorteiosBatalha = new SorteiosBatalha();

//	Realiza a batalha enquanto a classe Batalha solicitar
	public Combatente batalhar(int sorteado, Combatente combatente1, Combatente combatente2) throws InterruptedException {
		logicaBatalha(sorteado, combatente1, combatente2);

		return getVencedor(combatente1, combatente2);
	}

	private void logicaBatalha(int sorteado, Combatente combatente1, Combatente combatente2) throws InterruptedException {
		System.out.println(combatente1.getArma());
		System.out.println(combatente2.getArma());
		
		//		Se o sorteado for 1 começa por ele, se não começa pelo 2
		if (sorteado == 1) {
//			valorAtaque recebe o sorteio da força do ataque de acordo com o sorteio da força de quem vai atacar
			int valorAtaque = sorteiosBatalha.sorteiaAtaque(combatente1.getForca());
			boolean defendeu = sorteiosBatalha.sorteiaDefesa();

//			Se o adversário não defendeu, recebe dano inteiro
			if (defendeu == false) {
				System.out.println(
						combatente2.getNome() + " de jogador 2 vai receber " + valorAtaque + " de dano");
				
				combatente2.receberAtaque(valorAtaque);
			} else {
//				Se defendeu, recebe o ataque menos dano
				int ataqueMenosDefesa = valorAtaque - combatente2.getDefesa();

				if (ataqueMenosDefesa < 0) {
					ataqueMenosDefesa = 0;
				}

				System.out.println("(Jogador 1) - " + combatente1.getNome() + " ataque de (" + valorAtaque + ") | "
						+ "(Jogador 2) - " + combatente2.getNome() + "  defesa de (" + combatente2.getDefesa()
						+ ") \n");
				System.out.println(combatente2.getNome() + " de jogador 2 defendeu o ataque e sofreu dano de "
						+ ataqueMenosDefesa);

				combatente2.receberAtaque(ataqueMenosDefesa);
			}

			System.out.println("A vida de " + combatente1.getNome() + " - " + combatente1.getVidaAtual());
			System.out.println("A vida de " + combatente2.getNome() + " - " + combatente2.getVidaAtual());

			Thread.sleep(500);
			System.out.println("\n");
		} else {
			int valorAtaque = sorteiosBatalha.sorteiaAtaque(combatente2.getForca());
			boolean defendeu = sorteiosBatalha.sorteiaDefesa();

//			Se o adversário não defendeu, recebe dano inteiro
			if (defendeu == false) {
				System.out.println(
						combatente1.getNome() + " de jogador 1 vai receber " + valorAtaque + " de dano");
				combatente1.receberAtaque(valorAtaque);
			} else {
//				Se defendeu, recebe o ataque menos dano
				int ataqueMenosDefesa = valorAtaque - combatente1.getDefesa();

				if (ataqueMenosDefesa < 0) {
					ataqueMenosDefesa = 0;
				}

				System.out.println("(Jogador 2) - " + combatente2.getNome() + " ataque de (" + valorAtaque + ") | "
						+ "(Jogador 1) - " + combatente1.getNome() + "  defesa de (" + combatente1.getDefesa()
						+ ") \n");
				System.out.println(combatente1.getNome() + " de jogador 1 defendeu o ataque e sofreu dano de "
						+ ataqueMenosDefesa);

				combatente1.receberAtaque(ataqueMenosDefesa);
			}

			System.out.println("A vida de " + combatente1.getNome() + " - " + combatente1.getVidaAtual());
			System.out.println("A vida de " + combatente2.getNome() + " - " + combatente2.getVidaAtual());

			Thread.sleep(500);
			System.out.println("\n");
		}
	}

	private Combatente getVencedor(Combatente combatente1, Combatente combatente2) {
		if (combatente1.estaVivo()) {
			return combatente1;
		} else {
			return combatente2;
		}
	}
}
