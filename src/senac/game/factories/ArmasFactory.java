package senac.game.factories;

import java.util.HashMap;
import java.util.Map;

import senac.game.armas.*;
import senac.game.armas.adagas.*;
import senac.game.armas.clavas.*;
import senac.game.armas.espadas.*;
import senac.game.armas.machados.*;
import senac.game.armas.martelos.*;

public class ArmasFactory {
	public Map<Integer, Arma> armaMap = new HashMap<Integer, Arma>();

	private void criarArmas() {
		armaMap.put(1, new AdagaCongelante());
		armaMap.put(2, new AdagaCortante());
		armaMap.put(3, new AdagaFantasma());
		armaMap.put(4, new AdagaFlamejante());
		armaMap.put(5, new ClavaCongelante());
		armaMap.put(6, new ClavaEnvenenada());
		armaMap.put(7, new ClavaFantasma());
		armaMap.put(8, new ClavaFlamejante());
		armaMap.put(9, new EspadaCongelante());
		armaMap.put(10, new EspadaEnvenenada());
		armaMap.put(11, new EspadaFantasma());
		armaMap.put(12, new EspadaFlamejante());
		armaMap.put(13, new EspadaNordica());
		armaMap.put(14, new MachadoCongelante());
		armaMap.put(15, new MachadoCortante());
		armaMap.put(16, new MachadoFantasma());
		armaMap.put(17, new MarteloCongelante());
		armaMap.put(18, new MarteloEsmagador());
		armaMap.put(19, new MarteloFantasma());
		armaMap.put(20, new MarteloFlamejante());
	}
	
	public Arma selecionarArma(int valor) {
		this.criarArmas();
		return armaMap.get(valor);
	}
}
