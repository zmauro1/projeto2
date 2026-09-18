package projeto2;

public class EstrategiaVip implements EstrategiaJogador {

    @Override
    public int calcularPontos(double valorCompra) {
        return (int) (valorCompra / 5);
    }

    @Override
    public double calcularDesconto(double valorCompra) {
        return valorCompra * 0.90;
    }

    @Override
    public EstrategiaJogador verificarEvolucao(int pontos) {
        return this;
    }

    @Override
    public String getPatente() {
        return "Cliente VIP";
    }
}