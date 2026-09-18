package projeto2;

import java.util.ArrayList;
import java.util.HashMap;

public class SistemaLoja {
	private ArrayList<Jogo> jogos;
	private HashMap<Integer, Jogo> jogosPorCodigo;
	private ArrayList<Jogador> jogadores;
	private HashMap<Integer, Jogador> jogadoresPorCodigo;
	public SistemaLoja() {
		this.jogos = new ArrayList<>();
		this.jogosPorCodigo = new HashMap<>();
		this.jogadores = new ArrayList<>();
		this.jogadoresPorCodigo = new HashMap<>();
	}
	public Jogo buscarJogo(int codigo) {
		return jogosPorCodigo.get(codigo);
	}
	public Jogador buscarJogador(int codigo) {
	    return jogadoresPorCodigo.get(codigo);
	}
	public boolean cadastrarJogador(int codigo, String nome, String email) {
	    if (buscarJogador(codigo) != null) {
	        return false;
	    }

	    try {
	        Jogador jogador = new Jogador(codigo, nome, email, new EstrategiaComum());
	        jogadores.add(jogador);
	        jogadoresPorCodigo.put(codigo, jogador);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	public boolean cadastrarJogoFisico(int codigo, String titulo, String desenvolvedora, double precoBase, int anoLancamento,
	Categoria categoria, int qtdEstoque) {
		if(buscarJogo(codigo) != null) {
			return false;
		}
		try {
			Jogo jogoFisico = new JogoFisico(codigo, titulo, desenvolvedora, precoBase, anoLancamento, categoria, qtdEstoque);
			jogos.add(jogoFisico);
			jogosPorCodigo.put(codigo, jogoFisico);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public boolean cadastrarJogoDigital(int codigo, String titulo, String desenvolvedora, double precoBase, int anoLancamento,
			Categoria categoria, double tamanhoGB) {
		if(buscarJogo(codigo) != null) {
			return false;
		}
		try {
			Jogo jogoDigital = new JogoDigital(codigo, titulo, desenvolvedora, precoBase, anoLancamento, categoria, tamanhoGB);
			jogos.add(jogoDigital);
			jogosPorCodigo.put(codigo, jogoDigital);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public Jogo localizarMaisCaro() {
		if(jogos.isEmpty()) {
			return null;
		}
		Jogo maisCaro = jogos.get(0);
		for(int i = 1; i < jogos.size(); i++) {
			if(jogos.get(i).calcularPreco() > maisCaro.calcularPreco()) {
				maisCaro = jogos.get(i);
			}
		}
		return maisCaro;
	}
	public Jogo localizarMaisBarato() {
		if(jogos.isEmpty()) {
			return null;
		}
		Jogo maisBarato = jogos.get(0);
		for(int i = 1; i<jogos.size();i++) {
			if(jogos.get(i).calcularPreco() < maisBarato.calcularPreco()) {
				maisBarato = jogos.get(i);
			}
		}
		return maisBarato;
	}
	
	public double calcularValorTotal() {
		double valor = 0;
		for(int i = 0; i<jogos.size();i++) {
			valor += jogos.get(i).calcularPreco();
		}
		return valor;
	}
	public String listarJogos() {
		if(jogos.isEmpty()) {
			return "Nenhum jogo cadastrado";
		}
		String resultado = "";
		for(Jogo jogo: jogos) {
			resultado += jogo.toString() + "\n\n";
		}
		return resultado;
	}
	public String listarJogosCategoria(Categoria categoria) {
		if(jogos.isEmpty()) {
			return "Nenhum jogo cadastrado";
		}
		String resultado = "";
		for(Jogo jogo: jogos) {
			if(jogo.getCategoria() == categoria) {
				resultado += jogo + "\n\n"; 
			}
		}
		if(resultado.isBlank()) {
			return "Nenhum jogo cadastrado com essa categoria.";
		}
		return resultado;
	}
	public boolean alterarPrecoJogo(int codigo, double novoPreco) {
	    Jogo jogo = buscarJogo(codigo);

	    if (jogo == null) {
	        return false;
	    }

	    try {
	        jogo.alterarPrecoBase(novoPreco);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	public int contarJogos() {
	    return jogos.size();
	}
	public boolean comprarJogo(int codigoJogador, int codigoJogo) {
	    Jogador jogador = buscarJogador(codigoJogador);
	    if (jogador == null) {
	        return false;
	    }

	    Jogo jogo = buscarJogo(codigoJogo);
	    if (jogo == null) {
	        return false;
	    }

	    if (!jogo.comprar()) {
	        return false;
	    }

	  
	    jogador.realizarCompra(jogo.calcularPreco());

	    return true;
	   
	    
	}
	public String listarJogadores() {
	    if (jogadores.isEmpty()) {
	        return "Nenhum jogador cadastrado.";
	    }

	    String resultado = "";

	    for (Jogador jogador : jogadores) {
	        resultado += jogador + "\n\n";
	    }

	    return resultado;
	}
	public int contarJogadores() {
		return jogadores.size();
	}
}
