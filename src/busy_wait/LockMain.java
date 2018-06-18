package busy_wait;

import java.util.ArrayList;
import java.util.Scanner;

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

public class LockMain {
	private static Scanner scan;
	private static int count = 0;

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		LockMain lock = new LockMain();
		lock.init();

		while (true) {
			System.out.println("Deseja adicionar processo?\n 1 - Sim \n 2 - Não");
			int add = scan.nextInt();

			if (add == 1) { // Caso deseje adicionar mais processos
				lock.init();
			} else { // Finalização da entrada de processos
				System.out.println("Entrada de Processos Finalizada!!!");
				break;
			}
		}
	}

	public void init() {
		ArrayList<LockProcess> processos = new ArrayList<>();
		scan = new Scanner(System.in);
		System.out.println("Qtd de processos: ");
		int totalDeProcessos = scan.nextInt();
		scan.nextLine();

		// Criação e inicialização dos processos
		for (int i = 0; i < totalDeProcessos; i++) {
			LockProcess p = new LockProcess(++count);
			processos.add(p);
		}
		for (LockProcess processo : processos) {
			processo.start();
		}
	}
}
