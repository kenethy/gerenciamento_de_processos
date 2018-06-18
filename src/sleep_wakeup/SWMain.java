package sleep_wakeup;

import java.util.Scanner;

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

public class SWMain {

	private static Scanner scan;
	private static int sair = 0;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		System.out.println("Apos escolha do tamanho da lista, caso deseje finalizar digite 1 e enter");
		System.out.println("Informe o tamanho da lista:");
		int max = scan.nextInt();

		// Escolha do usuário tamanho da fila
		Fila fila = new Fila(max);

		// Inicialização do produtor e consumidor
		Produtor produtor = new Produtor(fila);
		Consumidor consumidor = new Consumidor(fila);

		produtor.start();
		consumidor.start();

		// Escolha de sair do usuário
		while (true) {
			sair = scan.nextInt();
			if (sair == 1) {
				Thread.sleep(5000);
				System.exit(sair);
			}
		}
	}
}
