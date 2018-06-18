package busy_wait;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Kenedy Silva
 * 
 * @category 1. Utilizando alguma linguagem de programa��o � sua escolha,
 *           implemente um "mini" simulador (mostrando a execu��o de, pelo
 *           menos, 5 processos do in�cio ao t�rmino de todos) de comunica��o
 *           inter-processos
 * 
 * @category a) Solu��es de software com busy wait (Vari�vel de bloqueio,
 *           Altern�ncia estrita ou Algoritmo de Peterson).
 * 
 * @version Vari�vel de Bloqueio
 */

public class LockMain {
	private static Scanner scan;
	private static int count = 0;

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		LockMain lock = new LockMain();
		lock.init();

		while (true) {
			System.out.println("Deseja adicionar processo?\n 1 - Sim \n 2 - N�o");
			int add = scan.nextInt();

			if (add == 1) { // Caso deseje adicionar mais processos
				lock.init();
			} else { // Finaliza��o da entrada de processos
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

		// Cria��o e inicializa��o dos processos
		for (int i = 0; i < totalDeProcessos; i++) {
			LockProcess p = new LockProcess(++count);
			processos.add(p);
		}
		for (LockProcess processo : processos) {
			processo.start();
		}
	}
}
