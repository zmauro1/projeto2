package projeto2;

public class EstrategiaFiel implements EstrategiaJogador {

    @Override
    public int calcularPontos(double valorCompra) {
        return (int) (valorCompra / 7);
    }

    @Override
    public double calcularDesconto(double valorCompra) {
        return valorCompra * 0.95;
    }

    @Override
    public EstrategiaJogador verificarEvolucao(int pontos) {
        if (pontos >= 300) {
            return new EstrategiaVip();
        }
        return this;
    }

    @Override
    public String getPatente() {
        return "Cliente Fiel";
    }
}
