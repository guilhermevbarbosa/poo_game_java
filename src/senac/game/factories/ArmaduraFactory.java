package senac.game.factories;

import java.util.HashMap;
import java.util.Map;

import senac.game.armaduras.*;
import senac.game.armaduras.botas.*;
import senac.game.armaduras.calcas.*;
import senac.game.armaduras.capacetes.*;
import senac.game.armaduras.peitoral.*;


public class ArmaduraFactory {

	public Map<Integer, Armadura> armaduraMap = new HashMap<Integer, Armadura>();

	private void criarArmaduras() {
		armaduraMap.put(1, new BotaBronze());
		armaduraMap.put(2, new BotaFantasma());
		armaduraMap.put(3, new BotaFogo());
		armaduraMap.put(4, new BotaGelo());
		armaduraMap.put(5, new BotaOuro());
		armaduraMap.put(6, new CalcaBronze());
		armaduraMap.put(7, new CalcaFantasma());
		armaduraMap.put(8, new CalcaFogo());
		armaduraMap.put(9, new CalcaGelo());
		armaduraMap.put(10, new CalcaOuro());
		armaduraMap.put(11, new CapaceteBronze());
		armaduraMap.put(12, new CapaceteFantasma());
		armaduraMap.put(13, new CapaceteFogo());
		armaduraMap.put(14, new CapaceteGelo());
		armaduraMap.put(15, new CapaceteOuro());
		armaduraMap.put(16, new PeitoralBronze());
		armaduraMap.put(17, new PeitoralFantasma());
		armaduraMap.put(18, new PeitoralFogo());
		armaduraMap.put(19, new PeitoralGelo());
		armaduraMap.put(20, new PeitoralOuro());
	}

	public Armadura selecionarArmadura(int valor) {
		this.criarArmaduras();
		return armaduraMap.get(valor);
	}

}
