package escalonamento;

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

public class Processo {
	private int id;
	private int duracao;
	private int duracaorestante;
	private int prioridade;

	public Processo(int id, int duracao, int duracaorestante, int prioridade) {
		super();
		this.id = id;
		this.duracao = duracao;
		this.duracaorestante = duracaorestante;
		this.prioridade = prioridade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getDuracaorestante() {
		return duracaorestante;
	}

	public void setDuracaorestante(int duracaorestante) {
		this.duracaorestante = duracaorestante;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	@Override
	public String toString() {
		return "Processo [id=" + id + ", " + "duracao=" + duracao + ", duracaorestante=" + duracaorestante
				+ ", prioridade=" + prioridade + "]";
	}
}