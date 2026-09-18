package projeto2;

public class JogoDigital extends Jogo {
	private double tamanhoGB;
	public JogoDigital(int codigo, String titulo, String desenvolvedora, double precoBase, int anoLancamento,
			Categoria categoria, double tamanhoGB) throws Exception {
		super(codigo, titulo, desenvolvedora, precoBase, anoLancamento, categoria);
		if(tamanhoGB <= 0.0) {
			throw new Exception("Tamanho invalido");
		}
		this.tamanhoGB = tamanhoGB;
	}

	public double getTamanhoGB() {
		return tamanhoGB;
	}

	@Override
	public double calcularPreco() {
		return super.getPrecoBase() * super.getCategoria().getDesconto();
	}

	@Override
	public boolean comprar() {
	    return true;
	}

	@Override
	public String toString() {
		return super.toString() + "\nTamanho: " + tamanhoGB;
	}
	
}
