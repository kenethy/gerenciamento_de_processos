package busy_wait;

/**
 * @author Kenedy Silva
 * 
 * @category 1. Utilizando alguma linguagem de programação à sua escolha,
 *           implemente um "mini" simulador (mostrando a execução de, pelo
 *           menos, 5 processos do início ao término de todos) de comunicação
 *           inter-processos
 * 
 * @category a) Soluções de software com busy wait (Variável de bloqueio,
 *           Alternância estrita ou Algoritmo de Peterson).
 * 
 * @version Variável de Bloqueio
 */

public class LockProcess extends Thread {

	int id;
	static boolean lock = false;

	public LockProcess(int id) {
		this.id = id;
	}

	public void critical_region() {
		lock = true; // R.C EM USO
		System.out.println("Processo " + id + " ENTROU na região critica!");
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void non_critical_region() {
		lock = false; // R.C LIVRE
		System.out.println("Processo " + id + " SAIU da região critica!");
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (lock) {
				System.out.println("Processo " + id + " em ESPERA!");
				Thread.sleep(5000);
			}
			// In Region Critic
			this.critical_region();
			// Out Region Critic
			this.non_critical_region();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
