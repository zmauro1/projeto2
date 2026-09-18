package projeto2;

public abstract class Jogo {
	private int codigo;
	private String titulo;
	private String desenvolvedora;
	private double precoBase;
	private int anoLancamento;
	private Categoria categoria;
	
	
	public Jogo(int codigo, String titulo, String desenvolvedora, double precoBase, 
			int anoLancamento, Categoria categoria) throws Exception {
		if(codigo <= 0) {
			throw new Exception("Código invalido");
		}
		if(titulo == null || titulo.isBlank()) {
			throw new Exception("Nome invalido");
		}
		if(titulo == null || desenvolvedora.isBlank()) {
			throw new Exception("Desenolvedora invalida");
		}
		if(precoBase <= 0) {
			throw new Exception("Preço invalido");
		}
		if(anoLancamento < 0) {
			throw new Exception("Ano de lançamento invalido");
		}
		this.codigo = codigo;
		this.titulo = titulo;
		this.desenvolvedora = desenvolvedora;
		this.precoBase = precoBase;
		this.anoLancamento = anoLancamento;
		this.categoria = categoria;
	}
	
	public abstract double calcularPreco(); 
	
	@Override
	public String toString() {
		return "Jogo: " + this.titulo + 
				"\nDesenvolvedora: " + this.desenvolvedora + 
				"\nAno de lancamento: " + this.anoLancamento + 
				"\nPreco: " + calcularPreco();
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDesenvolvedora() {
		return desenvolvedora;
	}

	public double getPrecoBase() {
		return precoBase;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void alterarPrecoBase(double novoPreco) throws Exception {
	    if (novoPreco <= 0) {
	        throw new Exception("Preço inválido");
	    }

	    this.precoBase = novoPreco;
	}
	public abstract boolean comprar();
		
}
