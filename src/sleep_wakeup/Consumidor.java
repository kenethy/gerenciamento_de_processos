package sleep_wakeup;

import java.util.Random;

/**
 * @author Kenedy Silva
 * 
 * @category 1. Utilizando alguma linguagem de programa��o � sua escolha,
 *           implemente um "mini" simulador (mostrando a execu��o de, pelo
 *           menos, 5 processos do in�cio ao t�rmino de todos) de comunica��o
 *           inter-processos
 * 
 * @category b) Solu��es de software com bloqueio (Sleep / Wakeup, Sem�foros ou
 *           Mutex, Monitor)
 * 
 * @version Sleep/Wakeup
 */

public class Consumidor extends Thread {
	Fila fila;
	Random r = new Random();

	public Consumidor(Fila fila) {
		// TODO Auto-generated constructor stub
		this.fila = fila;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			//synchronized (fila) {
				if (fila.fila_vazia()) { // Verifica��o da Fila
					try {
						System.out.println("FILA VAZIA");
						fila.wait(); // Sleep(consumidor)
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int item = fila.retira_item(); // Remove o item da fila
				fila.notifyAll(); // Wakeup(produtor)
				System.out.println("CONSUMIDO Item " + item + "!");
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//}
		}
	}
}