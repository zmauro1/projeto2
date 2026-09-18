package projeto2;

public enum Categoria {
	ACAO(0.95), RPG(0.90), ESPORTE(0.85), ESTRATEGIA(0.80), SIMULACAO(0.92);

	
	private double desconto;
	Categoria(double desconto) {
		this.desconto = desconto;
	}
	public double getDesconto() {
		return desconto;
	}
	
	
}
