package escalonamento;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

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

public class RoundRobin {
	private int quantum;
	private PriorityQueue<Processo> processos;
	private int quantProcessos;

	public RoundRobin(int quantum, int quantProcessos) {
		processos = new PriorityQueue<Processo>(quantProcessos, new Comparator<Processo>() {
			@Override // Comparator para realizar a ordenação pela prioridade
			public int compare(Processo processo1, Processo processo2) {
				return processo2.getPrioridade() - processo1.getPrioridade();
			}
		});

		// Informações de entrada do usuário
		this.quantum = quantum;
		this.quantProcessos = quantProcessos;

		// Criação aleatória de processos
		Random r = new Random();
		for (int i = 0; i < this.quantProcessos; i++) {
			int random = r.nextInt(12) + 1;
			this.processos.add(new Processo(i + 1, random, random, r.nextInt(quantProcessos)));
		}
		System.out.println();
	}

	public void run() throws InterruptedException {
		// Execução dos processos pela prioridade
		while (processos.size() > 0) {
			while (processos.size() > 0) {
				System.out.println("Processo em execução: " + processos.peek());

				int quantumaux = 0;

				for (int j = 0; j < quantum; j++) { // Execução do RoundRobin
					quantumaux++;
					System.out.println("Executando processo: " + processos.peek().getId());
					if (quantumaux <= quantum) {
						Thread.sleep(5000);
						processos.peek().setDuracaorestante(processos.peek().getDuracaorestante() - 1);
					} else
						break;

					if (processos.peek().getDuracaorestante() == 0) {
						System.out.println("Processo encerrado: " + processos.peek());
						processos.remove();
						break;
					}
				}

				// Verifica se a lista está vazia e se o processo ainda possui duração
				if (!processos.isEmpty())
					if (processos.peek().getDuracaorestante() > 0) {
						System.out.println("RETORNOU: " + processos.peek());
						processos.add(processos.poll());
						System.out.println("NOVO HEAD: " + processos.peek());
					}
			}
		}
	}
}