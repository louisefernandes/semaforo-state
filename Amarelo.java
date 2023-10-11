public class Amarelo implements SemaforoState {

    public Semaforo semaforo;

    public Amarelo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void efetuarTransicao(Semaforo semaforo) {
        semaforo.setEstado(new Vermelho(semaforo));
    }

    @Override
    public void showVisorRegressivo(Semaforo semaforo) {
        int countdown = semaforo.getTempoTransicao(Sinal.AMARELO);
        for (int i = countdown; i > 0; i--) {
            System.out.println(i + " segundo(s)");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Sinal getSinal() {
        return Sinal.AMARELO;
    }
}
