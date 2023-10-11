import java.util.HashMap;
import java.util.Map;

public class Semaforo {

	private SemaforoState estadoAtual;
	private String numTombamento = null;

	private boolean[] estado = {true,false,false};
	private Map<Sinal, Integer> transicao = new HashMap<Sinal,Integer>();

	public Semaforo(String numTombamento) {
		this.numTombamento = numTombamento;
		this.estadoAtual = new Vermelho(this);
		transicao.put(Sinal.VERMELHO, 3);
		transicao.put(Sinal.AMARELO, 1);
		transicao.put(Sinal.VERDE, 5);
	}

	public int getTempoTransicao(Sinal sinal) {
		return transicao.get(sinal);
	}
	
	public void setEstado(SemaforoState novoEstado) {
		this.estadoAtual = novoEstado;
	}
	
	
	public String getNumTombamento() {
		return numTombamento;
	}

	public void setNumTombamento(String numTombamento) {
		this.numTombamento = numTombamento;
	}
	
	public Sinal getEstadoAtual() {
		return estado[0]?Sinal.VERMELHO: (estado[1]?Sinal.AMARELO:Sinal.VERDE);
	}
	
	public void setup(Sinal estagio, int novo_tempo_transicao) {
		this.transicao.put(estagio,novo_tempo_transicao);
	}
	
	public void exibir() {
		System.out.println("Vermelho  (" + (estadoAtual instanceof Vermelho ? "X" : " ") + ")");
		System.out.println("Amarelo   (" + (estadoAtual instanceof Amarelo ? "X" : " ") + ")");
		System.out.println("Verde     (" + (estadoAtual instanceof Verde ? "X" : " ") + ")");
	}	
	
	public void efetuarTransicao() {
        estadoAtual.efetuarTransicao(this);
    }

    public void showVisorRegressivo() {
        estadoAtual.showVisorRegressivo(this);
    }

	public void start() {
		this.start(10);
	}

	public void start(int time_in_seconds) {
		while(time_in_seconds > 0) {
			System.out.println("Tempo restante da simulacao: " + time_in_seconds + " segundos");
			System.out.println( getEstadoAtual() + " : " + transicao.get(getEstadoAtual()) + " segundos.");
			exibir();
			time_in_seconds -= transicao.get(getEstadoAtual());
			showVisorRegressivo();
			efetuarTransicao();
			System.out.println();
			
		}
		
	}
	
	public String toString() {
		String s = "";
		s += "Numero Tombamento: " + numTombamento + "\n";
		s += "Tempo de permanencia em cada estagio:\n";
		s += Sinal.VERMELHO + " : " + transicao.get(Sinal.VERMELHO) + " segundos\n";
		s += Sinal.AMARELO + " : " + transicao.get(Sinal.AMARELO) + " segundos\n";
		s += Sinal.VERDE + " : " + transicao.get(Sinal.VERDE) + " segundos\n";
		return s;
	}

}
