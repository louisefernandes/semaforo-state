public class Verde implements SemaforoState {

    public Semaforo semaforo;

    public Verde(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void efetuarTransicao(Semaforo semaforo) {
        semaforo.setEstado(new Amarelo(semaforo));
    }

    @Override
    public void showVisorRegressivo(Semaforo semaforo) {
        int countdown = semaforo.getTempoTransicao(Sinal.VERDE);
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
        return Sinal.VERDE;
    }
}




