package senac.game.factories;

import java.util.HashMap;
import java.util.Map;

import senac.game.joias.*;

public class JoiasFactory {
	public Map<Integer, Joia> joiaMap = new HashMap<Integer, Joia>();

	private void criarJoias() {
		joiaMap.put(1, new JoiaAtaqueFraqueza());
		joiaMap.put(2, new JoiaAtaqueSorte());
		joiaMap.put(3, new JoiaDefesaFraqueza());
		joiaMap.put(4, new JoiaDefesaSorte());
		joiaMap.put(5, new JoiaFantasma());
		joiaMap.put(6, new JoiaFogo());
		joiaMap.put(7, new JoiaGelo());
		joiaMap.put(8, new JoiaNormal());
		joiaMap.put(9, new JoiaVenenosa());
	}

	public Joia selecionarJoia(int valor) {
		this.criarJoias();
		return joiaMap.get(valor);
	}
}
