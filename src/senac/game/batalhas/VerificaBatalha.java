package senac.game.batalhas;

import senac.game.combatentes.Combatente;
import senac.game.sorteios.SorteiosBatalha;
import senac.game.tipos.Tipo;

public class VerificaBatalha {

	SorteiosBatalha sorteiosBatalha = new SorteiosBatalha();
	VerificaFraquezas verificaFraquezas = new VerificaFraquezas();

//	Realiza a batalha enquanto a classe Batalha solicitar
	public Combatente batalhar(int sorteado, Combatente combatente1, Combatente combatente2)
			throws InterruptedException {
		logicaBatalha(sorteado, combatente1, combatente2);

		return getVencedor(combatente1, combatente2);
	}

	private void logicaBatalha(int sorteado, Combatente combatente1, Combatente combatente2)
			throws InterruptedException {

		// Se o sorteado for 1 começa por ele, se não começa pelo 2
		if (sorteado == 1) {
//			valorAtaque recebe o sorteio da força do ataque de acordo com o sorteio da força de quem vai atacar
			double valorAtaque = sorteiosBatalha.sorteiaAtaque(combatente1.getForca());
			boolean defendeu = sorteiosBatalha.sorteiaDefesa();

//			Realiza a verificação de tipos na batalha
			Tipo ataqueTipo = handleAtaque(combatente1);
			Tipo defesaTipo = handleDefesa(combatente2);

			double modificadorFraqueza = verificaFraquezas.verificaTipoAtaque(ataqueTipo, defesaTipo);
			valorAtaque = valorAtaque * modificadorFraqueza;

			System.out.println("O jogador 1 vai atacar com um ataque do tipo " + ataqueTipo
					+ " contra uma defesa do tipo " + defesaTipo
					+ " com isso, houve um modificador de multiplicação de " + modificadorFraqueza);

//			Se o adversário não defendeu, recebe dano inteiro
			if (defendeu == false) {
				System.out.println(combatente2.getNome() + " de jogador 2 vai receber " + valorAtaque + " de dano");

				combatente2.receberAtaque(valorAtaque);
			} else {
//				Se defendeu, recebe o ataque menos dano
				double ataqueMenosDefesa = valorAtaque - combatente2.getDefesa();

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
			double valorAtaque = sorteiosBatalha.sorteiaAtaque(combatente2.getForca());
			boolean defendeu = sorteiosBatalha.sorteiaDefesa();

//			Realiza a verificação de tipos na batalha
			Tipo ataqueTipo = handleAtaque(combatente2);
			Tipo defesaTipo = handleDefesa(combatente1);

			double modificadorFraqueza = verificaFraquezas.verificaTipoAtaque(ataqueTipo, defesaTipo);
			valorAtaque = valorAtaque * modificadorFraqueza;
			
			System.out.println("O jogador 2 vai atacar com um ataque do tipo " + ataqueTipo
					+ " contra uma defesa do tipo " + defesaTipo
					+ " com isso, houve um modificador de multiplicação de " + modificadorFraqueza);

//			Se o adversário não defendeu, recebe dano inteiro
			if (defendeu == false) {
				System.out.println(combatente1.getNome() + " de jogador 1 vai receber " + valorAtaque + " de dano");
				combatente1.receberAtaque(valorAtaque);
			} else {
//				Se defendeu, recebe o ataque menos dano
				double ataqueMenosDefesa = valorAtaque - combatente1.getDefesa();

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

	private Tipo handleAtaque(Combatente atacante) {
		if (atacante.getPodeReceberArmasEArmaduras()) {
			return atacante.getArma().getTipo();
		} else {
			return atacante.getTipo();
		}
	}

	private Tipo handleDefesa(Combatente defensor) {
		if (defensor.getPodeReceberArmasEArmaduras()) {
			return defensor.getArmadura().getTipo();
		} else {
			return defensor.getTipo();
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
