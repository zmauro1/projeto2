package projeto2;

public class Jogador {
	private int codigo;
	private String nome;
	private String email;
	private int pontos;
	private EstrategiaJogador estrategia;
	
	Jogador(int codigo, String nome, String email, EstrategiaJogador
			estrategia) throws Exception{
		if(codigo < 0) {
			throw new Exception("Código inválido.");
		}
		if(nome == null || nome.isBlank()) {
			throw new Exception("Nome invalido.");
		}
		if(email == null || email.isBlank()) {
			throw new Exception("Email invalido");
		}
		
		if(estrategia == null) {
			throw new Exception("Estrategia invalida");
		}
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.pontos = 0;
		this.estrategia = estrategia;
	}
	 public void realizarCompra(double valorCompra) {
	      pontos += estrategia.calcularPontos(valorCompra);
	      estrategia = estrategia.verificarEvolucao(pontos);
	  }
	 
	 public double calcularDesconto(double valorCompra) {
	      return estrategia.calcularDesconto(valorCompra);
	  }
	 public String toString() {
		 return "Codigo: " + codigo +
				 "\nNome: " + nome + 
				 "\nEmail: " + email +
				 "\nPontos: " + pontos +
				 "\nPatente: " + estrategia.getPatente();
	 }
	 public int getCodigo() {
		 return codigo;
	 }
	 public String getNome() {
		 return nome;
	 }
	 public String getEmail() {
		 return email;
	 }
	 public int getPontos() {
		 return pontos;
	 }
	 public EstrategiaJogador getEstrategia() {
		 return estrategia;
	 }
	 
}
