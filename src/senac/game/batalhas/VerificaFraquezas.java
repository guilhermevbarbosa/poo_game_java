package senac.game.batalhas;
import senac.game.tipos.Tipo;

public class VerificaFraquezas {

	public double verificaTipoAtaque(Tipo atacanteTipo, Tipo defensorTipo) {
//		GELO x NORMAL
		if (atacanteTipo.equals(Tipo.GELO) && defensorTipo.equals(Tipo.NORMAL)) {
			return 1.1;
		}

//		GELO x FOGO
		if (atacanteTipo.equals(Tipo.GELO) && defensorTipo.equals(Tipo.NORMAL)) {
			return 0.2;
		}

//		GELO x FANTASMA
		if (atacanteTipo.equals(Tipo.GELO) && defensorTipo.equals(Tipo.FANTASMA)) {
			return 1.3;
		}

//		FOGO x GELO
		if (atacanteTipo.equals(Tipo.FOGO) && defensorTipo.equals(Tipo.GELO)) {
			return 1.5;
		}

//		FOGO x NORMAL
		if (atacanteTipo.equals(Tipo.FOGO) && defensorTipo.equals(Tipo.NORMAL)) {
			return 1.1;
		}

//		FOGO x VENENO
		if (atacanteTipo.equals(Tipo.FOGO) && defensorTipo.equals(Tipo.VENENO)) {
			return 1.3;
		}

//		VENENO x NORMAL
		if (atacanteTipo.equals(Tipo.VENENO) && defensorTipo.equals(Tipo.NORMAL)) {
			return 1.3;
		}

//		VENENO x GELO
		if (atacanteTipo.equals(Tipo.VENENO) && defensorTipo.equals(Tipo.GELO)) {
			return 0.5;
		}

//		FANTASMA x NORMAL
		if (atacanteTipo.equals(Tipo.FANTASMA) && defensorTipo.equals(Tipo.NORMAL)) {
			return 1.3;
		}

//		FANTASMA x FOGO
		if (atacanteTipo.equals(Tipo.FANTASMA) && defensorTipo.equals(Tipo.FOGO)) {
			return 0.5;
		}

		return 1;
	}

}
