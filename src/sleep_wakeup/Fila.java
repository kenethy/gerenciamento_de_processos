package sleep_wakeup;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kenedy Silva
 * 
 * @category 1. Utilizando alguma linguagem de programação à sua escolha,
 *           implemente um "mini" simulador (mostrando a execução de, pelo
 *           menos, 5 processos do início ao término de todos) de comunicação
 *           inter-processos
 * 
 * @category b) Soluções de software com bloqueio (Sleep / Wakeup, Semáforos ou
 *           Mutex, Monitor)
 * 
 * @version Sleep/Wakeup
 */

public class Fila extends Thread {
	int maxFila;
	Queue<Integer> fila = new LinkedList<Integer>();

	public Fila(int max) {
		// TODO Auto-generated constructor stub
		this.maxFila = max;
	}

	public void deposita_item(int e) {
		fila.add(e);
	}

	public int retira_item() {
		return fila.poll();
	}

	public boolean fila_cheia() {
		return (fila.size() == maxFila);
	}

	public boolean fila_vazia() {
		return fila.isEmpty();
	}
}
