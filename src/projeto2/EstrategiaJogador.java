package projeto2;

public interface EstrategiaJogador {
	 int calcularPontos(double valorCompra);

	 double calcularDesconto(double valorCompra);

	 EstrategiaJogador verificarEvolucao(int pontos);

	 String getPatente();
}
