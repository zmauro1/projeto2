package projeto2;

public class JogoFisico extends Jogo {
	private static final double FRETE = 50.0;
	private int qtdEstoque;
	public JogoFisico(int codigo, String titulo, String desenvolvedora, double precoBase, int anoLancamento,
			Categoria categoria, int qtdEstoque) throws Exception {
		super(codigo, titulo, desenvolvedora, precoBase, anoLancamento, categoria);
		if(qtdEstoque < 0) {
			throw new Exception("Estoque invalido");
		}
		this.qtdEstoque = qtdEstoque;
	}

	@Override
	public double calcularPreco() {
		return super.getPrecoBase() * super.getCategoria().getDesconto() + FRETE;
	}
	
	
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	public boolean comprar() {
	    if (qtdEstoque > 0) {
	        qtdEstoque--;
	        return true;
	    }
	    return false;
	}
	@Override
	public String toString() {
		return super.toString() + "\nEstoque: " + this.qtdEstoque;
	}
	

}
