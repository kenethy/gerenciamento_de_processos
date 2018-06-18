package escalonamento;

import java.util.Scanner;

/**
 * @author Kenedy Silva
 * 
 * @category 2. Utilizando alguma linguagem de programação à sua escolha,
 *           implemente um "mini" simulador (mostrando a execução de, pelo
 *           menos, 10 processos do início ao término de todos) de escalonamento
 *           de processos, da abordagem de sistemas interativos (Round-robin,
 *           por prioridades, garantido, por loteria ou Fair-share, etc.)
 * 
 * @version Round-robin com Escalonamento por prioridades
 */

public class RRMain {
	private static Scanner scan;

	public static void main(String[] args) throws InterruptedException {
		scan = new Scanner(System.in);
		System.out.println("Informe o quantum do RR:");
		int quantum = scan.nextInt();
		scan.nextLine();
		System.out.println("Informe a quantidade de processos:");
		int processos = scan.nextInt();
		System.out.println("PROCESSOS INSERIDOS");
		(new RoundRobin(quantum, processos)).run();
	}
}
