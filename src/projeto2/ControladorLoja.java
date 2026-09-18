package projeto2;

public class ControladorLoja {
	private SistemaLoja sistema;
	
	public ControladorLoja() {
		sistema = new SistemaLoja();
	}
	
	
	public boolean cadastrarJogoFisico(int codigo, String titulo, String desenvolvedora, double precoBase, int anoLancamento,
			Categoria categoria, int qtdEstoque) {
	    return sistema.cadastrarJogoFisico(codigo, titulo, desenvolvedora, precoBase, anoLancamento, categoria, qtdEstoque);
	}
	public boolean cadastrarJogoDigital(int codigo, String titulo, String desenvolvedora, double precoBase, int anoLancamento,
			Categoria categoria, double tamanhoGB) {
		return sistema.cadastrarJogoDigital(codigo, titulo, desenvolvedora, precoBase, anoLancamento, categoria, tamanhoGB);
	}
	
	public Jogo buscarJogo(int codigo) {
	    return sistema.buscarJogo(codigo);
	}
	public Jogo localizarMaisCaro() {
		return sistema.localizarMaisCaro();
	}
	public Jogo localizarMaisBarato() {
		return sistema.localizarMaisBarato();
	}
	public boolean comprarJogo(int codigoJogador, int codigoJogo) {
		return sistema.comprarJogo(codigoJogador, codigoJogo);
	}
	public Jogador buscarJogador(int codigo) {
		return sistema.buscarJogador(codigo);
	}
	public boolean cadastrarJogador(int codigo, String nome, String email) {
		return sistema.cadastrarJogador(codigo, nome, email);
	}
	public double calcularValorTotal() {
		return sistema.calcularValorTotal();
	}
	public String listarJogos() {
		return sistema.listarJogos();
	}
	public String listarJogosCategoria(Categoria categoria) {
		return sistema.listarJogosCategoria(categoria);
	}
	public boolean alterarPrecoJogo(int codigo, double novoPreco) {
		return sistema.alterarPrecoJogo(codigo, novoPreco);
	}
	public int contarJogos() {
		return sistema.contarJogos();
	}
	public String listarJogadores() {
	    return sistema.listarJogadores();
	}
	public int contarJogadores() {
		return sistema.contarJogadores();
	}
}
