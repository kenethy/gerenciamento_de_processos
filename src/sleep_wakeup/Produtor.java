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

public class Produtor extends Thread {
	Fila fila;
	Random r = new Random();

	public Produtor(Fila fila) {
		// TODO Auto-generated constructor stub
		this.fila = fila;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			//synchronized (fila) {
				int item = r.nextInt(100); // Cria��o do item a ser inserido
				if (fila.fila_cheia()) { // Verifica�ao da fila
					try {
						System.out.println("FILA CHEIA!"); // Caso seja, espera consumidor
						fila.wait(); // Sleep(produtor)
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("PRODUZIDO Item " + item + "!");
				fila.deposita_item(item);
				fila.notifyAll(); // Wakeup(consumidor)
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
