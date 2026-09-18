package projeto2;

public class EstrategiaComum implements EstrategiaJogador {

	@Override
	public int calcularPontos(double valorCompra) {
		return (int) (valorCompra/10);
	}

	@Override
	public double calcularDesconto(double valorCompra) {
		return valorCompra;
	}

	@Override
	public EstrategiaJogador verificarEvolucao(int pontos) {
		if(pontos >= 100 && pontos < 300) {
			return new EstrategiaFiel();
		}
		return this;
	}

	@Override
	public String getPatente() {
		return "Cliente comum";
	}

}
