package projeto2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ControladorTest {
	private ControladorLoja controlador = new ControladorLoja();
	
	
	@Test
	public void deveIniciarSemJogosCadastrados() {
	    assertEquals(0, controlador.contarJogos());
	    assertEquals("Nenhum jogo cadastrado", controlador.listarJogos());
	    assertEquals(0.0, controlador.calcularValorTotal(), 0.001);
	    assertNull(controlador.localizarMaisCaro());
	    assertNull(controlador.localizarMaisBarato());

	    assertEquals(0, controlador.contarJogadores());
	    assertEquals("Nenhum jogador cadastrado.", controlador.listarJogadores());
	}
	@Test
	public void deveCadastrarUmJogoFisicoEUmDigital() {
	    assertTrue(controlador.cadastrarJogoFisico(
	            101,
	            "God of War",
	            "Santa Monica Studio",
	            200.0,
	            2022,
	            Categoria.ACAO,
	            10));

	    assertTrue(controlador.cadastrarJogoDigital(
	            102,
	            "The Witcher 3",
	            "CD Projekt Red",
	            150.0,
	            2015,
	            Categoria.RPG,
	            50.0));

	    assertEquals(2, controlador.contarJogos());
	}
	@Test
	public void deveCadastrarUmJogador() {
	    assertTrue(controlador.cadastrarJogador(
	            1,
	            "Mauro",
	            "mauro@email.com"));

	    assertEquals(1, controlador.contarJogadores());
	}
	@Test
	public void deveBuscarUmJogador() {
	    controlador.cadastrarJogador(
	            1,
	            "Mauro",
	            "mauro@email.com");

	    Jogador jogador = controlador.buscarJogador(1);

	    assertNotNull(jogador);
	    assertEquals("Mauro", jogador.getNome());
	}
	@Test
	public void deveBuscarUmJogo() {
	    controlador.cadastrarJogoFisico(
	            101,
	            "God of War",
	            "Santa Monica Studio",
	            200.0,
	            2022,
	            Categoria.ACAO,
	            10);

	    Jogo jogo = controlador.buscarJogo(101);

	    assertNotNull(jogo);
	    assertEquals("God of War", jogo.getTitulo());
	}
	@Test
	public void deveComprarUmJogoFisico() {
	    controlador.cadastrarJogador(
	            1,
	            "Mauro",
	            "mauro@email.com");

	    controlador.cadastrarJogoFisico(
	            101,
	            "God of War",
	            "Santa Monica Studio",
	            200.0,
	            2022,
	            Categoria.ACAO,
	            10);

	    assertTrue(controlador.comprarJogo(1, 101));

	    JogoFisico jogo = (JogoFisico) controlador.buscarJogo(101);

	    assertEquals(9, jogo.getQtdEstoque());
	}
	@Test
	public void deveComprarUmJogoDigital() {
	    controlador.cadastrarJogador(
	            1,
	            "Mauro",
	            "mauro@email.com");

	    controlador.cadastrarJogoDigital(
	            102,
	            "The Witcher 3",
	            "CD Projekt Red",
	            150.0,
	            2015,
	            Categoria.RPG,
	            50.0);

	    assertTrue(controlador.comprarJogo(1, 102));
	}
	@Test
	public void jogadorDeveGanharPontosAoComprar() {
	    controlador.cadastrarJogador(
	            1,
	            "Mauro",
	            "mauro@email.com");

	    controlador.cadastrarJogoDigital(
	            102,
	            "The Witcher 3",
	            "CD Projekt Red",
	            200.0,
	            2015,
	            Categoria.RPG,
	            50.0);

	    controlador.comprarJogo(1, 102);

	    Jogador jogador = controlador.buscarJogador(1);

	    assertEquals(18, jogador.getPontos());
	}
	@Test
	public void jogadorDeveSubirParaClienteFiel() {
	    controlador.cadastrarJogador(
	            1,
	            "Mauro",
	            "mauro@email.com");

	    controlador.cadastrarJogoDigital(
	            102,
	            "Jogo",
	            "Empresa",
	            1200.0,
	            2024,
	            Categoria.RPG,
	            20);

	    controlador.comprarJogo(1, 102);

	    Jogador jogador = controlador.buscarJogador(1);

	    assertEquals("Cliente Fiel",
	            jogador.getEstrategia().getPatente());
	}
	@Test
	public void jogadorDeveSubirParaClienteVip() {
	    controlador.cadastrarJogador(
	            1,
	            "Mauro",
	            "mauro@email.com");

	    controlador.cadastrarJogoDigital(
	            102,
	            "Jogo",
	            "Empresa",
	            2000.0,
	            2024,
	            Categoria.RPG,
	            20);

	    controlador.comprarJogo(1, 102);
	    controlador.comprarJogo(1, 102);

	    Jogador jogador = controlador.buscarJogador(1);

	    assertEquals("Cliente VIP",
	            jogador.getEstrategia().getPatente());
	}
	@Test
	public void deveLocalizarJogoMaisCaro() {
	    controlador.cadastrarJogoFisico(
	            101,
	            "God of War",
	            "Santa Monica Studio",
	            200.0,
	            2022,
	            Categoria.ACAO,
	            10);

	    controlador.cadastrarJogoDigital(
	            102,
	            "The Witcher 3",
	            "CD Projekt Red",
	            150.0,
	            2015,
	            Categoria.RPG,
	            50.0);

	    Jogo jogo = controlador.localizarMaisCaro();

	    assertEquals("God of War", jogo.getTitulo());
	}
	
}
