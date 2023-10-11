public interface SemaforoState {
    void efetuarTransicao(Semaforo semaforo);
    void showVisorRegressivo(Semaforo semaforo);
    Sinal getSinal();
}
